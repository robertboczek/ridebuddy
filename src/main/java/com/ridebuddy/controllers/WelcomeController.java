package com.ridebuddy.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);
	
	@RequestMapping(value="/welcome")
	public String welcome(Model model, HttpSession session) {
		return "welcome";
	}
}
