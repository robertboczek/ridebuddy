package com.ridebuddy.models;

import java.io.Serializable;

import com.amazonaws.services.dynamodb.datamodeling.DynamoDBVersionAttribute;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = -6532786020442679277L;
	
	private int version;

	@DynamoDBVersionAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
