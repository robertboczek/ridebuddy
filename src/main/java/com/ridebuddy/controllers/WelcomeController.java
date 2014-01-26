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
		
		List<Posts> posts = postsDao.scan();
		List<Credentials> credentialsList = credentialsDao.scan();
		
		List<ActivePosts> activePosts = new ArrayList<ActivePosts>();
		for (Posts post : posts) {
			ActivePosts activePost = new ActivePosts();
			activePost.setPostContent(post.getContent());
			activePost.setPostTime(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(post.getDate()));
			for (Credentials credentials : credentialsList) {
				logger.info(credentials.getEmail() + " " + post.getEmail());
				if (credentials.getEmail().equals(post.getEmail())) {
					activePost.setUserUrl(credentials.getImgSrc());
					activePost.setUserName(credentials.getFirstName() + " " + credentials.getLastName());
					break;
				}
			}
			activePosts.add(activePost);
		}
		model.asMap().put("posts", activePosts);
		
		return "welcome";
	}
}
