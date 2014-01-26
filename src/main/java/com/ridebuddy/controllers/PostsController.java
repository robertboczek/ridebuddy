package com.ridebuddy.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ridebuddy.dao.CredentialsDao;
import com.ridebuddy.dao.PostsDao;
import com.ridebuddy.models.Credentials;
import com.ridebuddy.models.Posts;
import com.ridebuddy.ui.models.ActivePosts;
import com.ridebuddy.ui.models.User;

@Controller
public class PostsController extends AbstractController {

	private static final Logger logger = Logger.getLogger(PostsController.class);

	private static final String SUCCESS = "SUCCESS";
	
	@Autowired
	private PostsDao postsDao;
	
	@Autowired
	private CredentialsDao credentialsDao;
	
	@RequestMapping(value="/newPost", method = RequestMethod.GET)
	@ResponseBody
	public String createNewPost(Posts post, HttpSession session) {
		User user = getUserFromSession(session);
		post.setEmail(user.getEmail());
		post.setPostId(UUID.randomUUID().toString().replace("-", ""));
		postsDao.save(post);
		
		return SUCCESS;
	}
	
	@RequestMapping(value = "/allPosts")
	public String allPosts(Model model, HttpSession httpSession) {
		
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
		
		logger.info("FDASFDFDSAFDS");
		
		return "allPosts";
	}
}
