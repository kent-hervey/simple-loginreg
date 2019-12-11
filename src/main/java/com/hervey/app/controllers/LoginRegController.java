package com.hervey.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hervey.app.models.User;
import com.hervey.app.services.ApiService;
import com.hervey.app.validator.UserValidator;

@Controller
public class LoginRegController {
	private final ApiService apiService;
	private final UserValidator userValidator;
	
	public LoginRegController(UserValidator userValidator, ApiService apiService) {
		this.apiService = apiService;
		this.userValidator = userValidator;
		
	}
	
	@GetMapping("/loginreg")
	public String showLoginreg(@ModelAttribute("user") User user) {
		return "loginReg.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
		userValidator.validate(user, result);
		System.out.println("all errors" + result.toString());
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("registrationError", "Registration failed!  Please ensure you have filled in each field and password entries match");
			return "redirect:/loginreg";
		}
		try {
			if(apiService.isEmailAlreadyRegistered(user)) {
				System.out.println("throwing for dupe email");
				throw new Exception ("duplicate email thrown");
			}
			else {
				System.out.println("not existing email, so cna register");
				apiService.registerUser(user);
				session.setAttribute("userId", user.getId());
				//user.setNumLogins(user.getNumLogins()+1);
				apiService.incrementLoginCount(user);
				redirectAttributes.addFlashAttribute("preLoginMessage", "Registration Successful");
		return "redirect:/userList"; 				
				
			}
		}
		catch(Exception exception) {
			//Flash message if email already exists
			redirectAttributes.addFlashAttribute("registrationErrorDup", "Duplicate credentials, please try again");
			return "redirect:/loginreg";
		}
		
	}
	
	//not working
	@GetMapping("/showchange")
	public String showchange(@ModelAttribute("user") User user) {
		return "loginReg2.jsp";
	}
	
	//not working
	@PostMapping("/changePassword")
	public String changePassword(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
		userValidator.validate(user, result);
		System.out.println("all errors" + result.toString());
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("registrationError", "Registration failed!  Please ensure you have filled in each field and password entries match");
			return "redirect:/changePassword";
		}

				apiService.registerUser(user);
				session.setAttribute("userId", user.getId());
				//user.setNumLogins(user.getNumLogins()+1);
				apiService.incrementLoginCount(user);
				redirectAttributes.addFlashAttribute("preLoginMessage", "Registration Successful");
		return "redirect:/userList"; 				

	}
	
	
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes, HttpSession session) {
		if(apiService.authenticateUser(email, password)) {
			User user = apiService.fetchByEmail(email);
			session.setAttribute("userId", user.getId());
			System.out.println("pre numLogins:  " +user.getNumLogins());
			//user.setNumLogins(user.getNumLogins()+1);
			apiService.incrementLoginCount(user);
			System.out.println("post numLogins:  " +user.getNumLogins());
			return "redirect:/userList";
		}
		redirectAttributes.addFlashAttribute("loginError", "login failed");
		return "redirect:/loginreg";
	}
	
	
	//logout
	@PostMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("logoutSuccess", "You Have successfully logged out.");
		return "redirect:/loginreg";
	}
	
	
	
	@GetMapping("/users")
	public String showEditUser(Model model, HttpSession session) {
		
		if(session.getAttribute("userId")==null) {
			return "redirect:/loginreg";
		}
		Long userId = (Long) session.getAttribute("userId");
 		User user = apiService.fetchById(userId);
 		model.addAttribute("user",user);


		
		return "editUser.jsp";
	}
	
	@PutMapping("/users2/{id}")
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result, @PathVariable("id") Long userId, HttpSession session) {
		System.out.println("id passed in as PathVariable is;  " + userId);
		
		User userFromDB = apiService.fetchById(userId);
		System.out.println("jpaUser toString:  " + userFromDB.toString());
		System.out.println("user toString:  " + user.toString());
		
		userFromDB.setGoldStatus(user.getGoldStatus());
		userFromDB.setUserName(user.getUserName());
		userFromDB.setUserLocation(user.getUserLocation());
		userFromDB.setPersonalDescription(user.getPersonalDescription());
		
		System.out.println("UPDATED jpaUser toString:  " + userFromDB.toString());
		apiService.userSave(userFromDB);
		return "redirect:/userList";
	}
	
	
	
}
