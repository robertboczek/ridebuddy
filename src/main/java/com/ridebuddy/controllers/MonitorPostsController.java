package com.ridebuddy.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ridebuddy.dao.CredentialsDao;
import com.ridebuddy.dao.PostsDao;
import com.ridebuddy.dao.RidesDao;
import com.ridebuddy.models.Posts;
import com.ridebuddy.models.Rides;

@Controller
public class MonitorPostsController {

	@Autowired
	private CredentialsDao credentialsDao;
	
	@Autowired
	private PostsDao postsDao;
	
	@Autowired
	private RidesDao ridesDao;
	
	public String getNewPosts() {
		
		return "0";
	}
	
	@RequestMapping(value = "/fdsfsd")
	public String getRideJoins() {
		
		return "0";
	}
}
