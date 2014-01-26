package com.ridebuddy.ui.models;

public class ActivePosts {

	private String userUrl, userName, postTime, postContent, postId;
	private int numJoined;

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	public int getNumJoined() {
		return numJoined;
	}

	public void setNumJoined(int numJoined) {
		this.numJoined = numJoined;
	}
}
