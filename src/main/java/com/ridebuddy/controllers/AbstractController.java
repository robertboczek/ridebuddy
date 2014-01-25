package com.ridebuddy.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ridebuddy.filters.SecurityFilter;
import com.ridebuddy.ui.models.User;

public abstract class AbstractController {
	
	private static final Logger logger = Logger.getLogger(AbstractController.class);
	
	protected static final String errorMessage = "errorMessage";
	
	protected static final String infoMessage = "infoMessage";

	protected void saveUserInSession(HttpSession session, User user) {
		session.setAttribute(SecurityFilter.AUTHORIZED_KEY, true);
		session.setAttribute("user", user);
		logger.info("Saving session");
	}
}
