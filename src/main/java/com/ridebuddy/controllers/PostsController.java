package com.ridebuddy.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ridebuddy.dao.PostsDao;
import com.ridebuddy.models.Posts;
import com.ridebuddy.ui.models.User;

@Controller
public class PostsController extends AbstractController {

	private static final Logger logger = Logger.getLogger(PostsController.class);

	private static final String SUCCESS = "SUCCESS";
	
	@Autowired
	private PostsDao postsDao;
	
	@RequestMapping(value="/newPost", method = RequestMethod.GET)
	@ResponseBody
	public String createNewPost(Posts post, HttpSession session) {
		User user = getUserFromSession(session);
		post.setEmail(user.getEmail());
		postsDao.save(post);
		
		return SUCCESS;
	}
}
