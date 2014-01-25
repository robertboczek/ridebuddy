package com.ridebuddy.util.models;

public class MailMessage {

	private final String from = "whereismymobile@gmail.com";
	private String to, body, subject;
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getFrom() {
		return from;
	}

	@Override
	public String toString() {
		return "MailMessage [from=" + from + ", to=" + to + ", body=" + body
				+ ", subject=" + subject + "]";
	}
}
