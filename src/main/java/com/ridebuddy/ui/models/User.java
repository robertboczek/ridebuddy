package com.ridebuddy.ui.models;

import java.io.Serializable;

import com.ridebuddy.models.Credentials;


public class User implements Serializable {

	private String firstName, lastName, imgSrc, email;

	public User(Credentials credentials) {
		this.firstName = credentials.getFirstName();
		this.lastName = credentials.getLastName();
		this.imgSrc = credentials.getImgSrc();
		this.email = credentials.getEmail();
	}

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
