package com.hervey.app.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hervey.app.models.User;
import com.hervey.app.services.ApiService;

@Controller
public class WelcomeAndDisplayController {
	
	private final ApiService apiService;
	
	public WelcomeAndDisplayController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	//Routes
	
	@GetMapping("/")
	public String dashboard(Model model, HttpSession session) {
		String loggedinUserName;
		if(session.getAttribute("userId") == null) {
			loggedinUserName = "None";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			loggedinUserName = apiService.fetchUserNameFromUserID(userId);
			model.addAttribute("userId", userId);
		}
		model.addAttribute("loggednUserName", loggedinUserName);

		
		return "/dashboard.jsp";
	}
	
	@GetMapping("/userList")
	public String userList(Model model, HttpSession session) {
		List<User> users = apiService.fetchAllUsers();
		model.addAttribute("users", users);
		String loggedinUserName;
		if(session.getAttribute("userId") == null) {
			loggedinUserName = "None";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			loggedinUserName = apiService.fetchUserNameFromUserID(userId);
		}
		model.addAttribute("loggednUserName", loggedinUserName);
		

		
				
				
		return "/showUsers.jsp";
	}
	
	
	
	

}
