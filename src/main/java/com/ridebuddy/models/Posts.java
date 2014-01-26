package com.ridebuddy.models;

import java.util.Date;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Posts")
public class Posts extends Entity {

	private String email, content;
	private String time, postId;
	
	@DynamoDBHashKey(attributeName="email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@DynamoDBAttribute
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@DynamoDBRangeKey(attributeName="time")
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@DynamoDBIgnore
	public Date getDate() {
		return new Date(Long.valueOf(time));
	}
	
	@DynamoDBAttribute
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Override
	public int compareTo(Object object) {
		if (object == null || !(object instanceof Posts)) {
			return 1;
		}
		Posts posts = (Posts) object;
		
		return Long.valueOf(this.time).compareTo(Long.valueOf(posts.time));
	}
}
