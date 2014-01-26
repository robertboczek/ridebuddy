package com.ridebuddy.models;

import java.util.Date;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodb.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Rides")
public class Rides extends Entity {

	private long postId;
	private String email;
	
	@DynamoDBHashKey(attributeName="postId")
	public long getPostId() {
		return postId;
	}
	
	public void setPostId(long postId) {
		this.postId = postId;
	}
	
	@DynamoDBRangeKey(attributeName="email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int compareTo(Object object) {
		if (object == null || !(object instanceof Rides)) {
			return 1;
		}
		Rides rides = (Rides) object;
		
		return Long.valueOf(this.postId).compareTo(Long.valueOf(rides.postId));
	}
}
