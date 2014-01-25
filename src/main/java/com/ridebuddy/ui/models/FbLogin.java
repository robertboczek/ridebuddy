package com.ridebuddy.ui.models;

public class FbLogin {

	private String code,state;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "FbLogin [code=" + code + ", state=" + state + "]";
	}
}
