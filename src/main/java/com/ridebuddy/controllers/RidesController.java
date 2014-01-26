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
import com.ridebuddy.dao.RidesDao;
import com.ridebuddy.models.Credentials;
import com.ridebuddy.models.Posts;
import com.ridebuddy.models.Rides;
import com.ridebuddy.ui.models.ActivePosts;
import com.ridebuddy.ui.models.User;

@Controller
public class RidesController extends AbstractController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);
	
	@Autowired
	private PostsDao postsDao;
	
	@Autowired
	private RidesDao ridesDao;
	
	@Autowired
	private CredentialsDao credentialsDao;
	
	private List<ActivePosts> getActivePostsForUser(List<Posts> posts, List<Credentials> credList, User user)
	{
		List<ActivePosts> myPosts = new ArrayList<ActivePosts>();
		for (Posts post : posts) {
		    if (post.getEmail().equals(user.getEmail())) {
				ActivePosts activePost = new ActivePosts();
				activePost.setPostContent(post.getContent());
				activePost.setPostTime(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(post.getDate()));
				for (Credentials credentials : credList) {
					logger.info(credentials.getEmail() + " " + post.getEmail());
					if (credentials.getEmail().equals(post.getEmail())) {
						activePost.setUserUrl(credentials.getImgSrc());
						activePost.setUserName(credentials.getFirstName() + " " + credentials.getLastName());
						break;
					}
				}
				myPosts.add(activePost);
			}
		}
		return myPosts;
	}
	
	private ActivePosts getActivePostById(List<Posts> posts, List<Credentials> credList, long postId)
	{
		ActivePosts activePost = new ActivePosts();
		for (Posts post : posts) {
		    if (post.getPostId().equals(postId)) {
				activePost.setPostContent(post.getContent());
				activePost.setPostTime(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(post.getDate()));
				for (Credentials credentials : credList) {
					logger.info(credentials.getEmail() + " " + post.getEmail());
					if (credentials.getEmail().equals(post.getEmail())) {
						activePost.setUserUrl(credentials.getImgSrc());
						activePost.setUserName(credentials.getFirstName() + " " + credentials.getLastName());
						break;
					}
				}
				break;
			}
		}
		return activePost;
	}
	
	@RequestMapping(value="/myrides")
	public String myrides(Model model, HttpSession session) {
		
		List<Posts> posts = postsDao.scan();
		List<Rides> rides = ridesDao.scan();
		List<Credentials> credentialsList = credentialsDao.scan();
		
		User user = getUserFromSession(session);
		
		// Posts created by me
		List<ActivePosts> myPosts = getActivePostsForUser(posts, credentialsList, user);
		model.asMap().put("myposts", myPosts);
		
		// Posts created by others but followed by me
		List<ActivePosts> otherPosts = new ArrayList<ActivePosts>();
		for (Rides ride : rides) {
			if (ride.getEmail().equals(user.getEmail())) {
				otherPosts.add(getActivePostById(posts, credentialsList, ride.getPostId()));
			}
		}
		model.asMap().put("otherPosts", otherPosts);
		
		logger.info("FDSAFDASFDSADFDS");
		return "myrides";
	}
}
