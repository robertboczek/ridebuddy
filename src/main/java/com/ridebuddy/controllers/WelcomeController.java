package com.ridebuddy.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ridebuddy.dao.CredentialsDao;
import com.ridebuddy.dao.PostsDao;
import com.ridebuddy.models.Credentials;
import com.ridebuddy.models.Posts;
import com.ridebuddy.ui.models.ActivePosts;

@Controller
public class WelcomeController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);
	
	@Autowired
	private PostsDao postsDao;
	
	@Autowired
	private CredentialsDao credentialsDao;
	
	@RequestMapping(value="/welcome")
	public String welcome(Model model, HttpSession session) {
		
		return "welcome";
	}
}
