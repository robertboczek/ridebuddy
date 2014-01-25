package com.ridebuddy.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ridebuddy.filters.SecurityFilter;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.setAttribute(SecurityFilter.AUTHORIZED_KEY, false);
		session.invalidate();
		
		return "redirect:login";
	}
}
