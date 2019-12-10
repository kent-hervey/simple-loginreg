package com.hervey.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hervey.app.models.User;
import com.hervey.app.repositories.UserRepository;
import com.hervey.app.services.ApiService;

@Controller
public class TestController {
	private final ApiService apiService;
	//private final UserValidator userValidator;
	private final UserRepository userRepository;
	
	public TestController(UserRepository userRepository, ApiService apiService) {
		this.apiService = apiService;
		//this.userValidator = userValidator;
		this.userRepository = userRepository;
		
		
	}

	
	@GetMapping("/createUser")
	public String createUser() {
		User newUser = new User();
		newUser.setUserName("chubba");
		
		newUser.setGoldStatus(true);
		newUser.setEmail("cbubba@bubba.com");
		newUser.setPersonalDescription("chunter and fisher");
		newUser.setPassword("asdfasdf");
		newUser.setUserLocation("Texas");
		//newUser.setNumLogins(newUser.getNumLogins()+1);
		
		System.out.println(newUser.getUserName());
		userRepository.save(newUser);
		System.out.println(newUser.toString());
		
		return "user";
	}
	
	
	@GetMapping("/addOrChangePersonalDescription")
	public String addChange() {
		User user = apiService.fetchByEmail("abe@abe.com");
		user.setGoldStatus(false);
		user.setPersonalDescription("Abe reads");
		userRepository.save(user);
		
		
		
		return "user";
	}
	
	
	

}
