package com.ridebuddy.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ridebuddy.filters.SecurityFilter;
import com.ridebuddy.ui.models.User;

public abstract class AbstractController {
	
	private static final Logger logger = Logger.getLogger(AbstractController.class);
	
	protected static final String errorMessage = "errorMessage";
	
	protected static final String infoMessage = "infoMessage";

	private static final String USER_KEY = "user";

	protected void saveUserInSession(HttpSession session, User user) {
		session.setAttribute(SecurityFilter.AUTHORIZED_KEY, true);
		session.setAttribute(USER_KEY, user);
		logger.info("Saving session");
	}
	
	protected User getUserFromSession(HttpSession session) {
		User user = null;
		if ((Boolean)session.getAttribute(SecurityFilter.AUTHORIZED_KEY)) {
			user = (User) session.getAttribute(USER_KEY);
		}
		return user;
	}
}
