package com.hervey.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayTestController {

	@GetMapping("/displaytest")
	public String displayTest() {
		return "displaytest.jsp";
	}
	
	
	
	
	
	
	
	
	
}
