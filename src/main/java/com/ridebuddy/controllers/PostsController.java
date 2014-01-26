package com.ridebuddy.controllers;

import java.text.ParseException;
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
import com.ridebuddy.dao.RidesDao;
import com.ridebuddy.models.Credentials;
import com.ridebuddy.models.Posts;
import com.ridebuddy.models.Rides;
import com.ridebuddy.ui.models.ActivePosts;
import com.ridebuddy.ui.models.User;

@Controller
public class PostsController extends AbstractController {

	private static final Logger logger = Logger.getLogger(PostsController.class);

	private static final String SUCCESS = "SUCCESS";
	private static final String FAILURE = "FAILURE";
	
	@Autowired
	private PostsDao postsDao;
	
	@Autowired
	private RidesDao ridesDao;
	
	@Autowired
	private CredentialsDao credentialsDao;
	
	@RequestMapping(value="/newPost", method = RequestMethod.GET)
	@ResponseBody
	public String createNewPost(Posts post, HttpSession session) {
		try {
			logger.info("Time: " + post.getTime());
			post.setTime(Long.valueOf(new SimpleDateFormat("yyyy-mm-dd hh:mm").parse(post.getTime()).getTime()).toString());
			User user = getUserFromSession(session);
			post.setEmail(user.getEmail());
			post.setPostId(UUID.randomUUID().toString().replace("-", ""));
			postsDao.save(post);
		
			return SUCCESS;
		} catch (ParseException e) {
			logger.error(e);
			return FAILURE;
		}
		
	}
	
	@RequestMapping(value = "/allPosts")
	public String allPosts(Model model, HttpSession httpSession) {
		
		List<Posts> posts = postsDao.scan();
		List<Rides> rides = ridesDao.scan();
		List<Credentials> credentialsList = credentialsDao.scan();
		
		List<ActivePosts> activePosts = new ArrayList<ActivePosts>();
		for (Posts post : posts) {
			ActivePosts activePost = new ActivePosts();
			activePost.setPostContent(post.getContent());
			activePost.setPostTime(new SimpleDateFormat("yyyy-mm-dd hh:mm").format(post.getDate()));
			activePost.setPostId(post.getPostId());
			
			// Find and add rides too
			for (Rides ride : rides)
			{
				if (ride.getPostId().equals(post.getPostId()))
				{
					int numJoined = activePost.getNumJoined() + 1;
					activePost.setNumJoined(numJoined);
				}
			}
			
			for (Credentials credentials : credentialsList) {
				if (credentials.getEmail().equals(post.getEmail())) {
					activePost.setUserUrl(credentials.getImgSrc());
					activePost.setUserName(credentials.getFirstName() + " " + credentials.getLastName());
					break;
				}
			}
			activePosts.add(activePost);
		}
		model.asMap().put("posts", activePosts);
		
		return "allPosts";
	}
}
