package com.paathshala.flight.flightservice.model;

public class MessagePublish {

	private Message message;
	private String hostname;
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
}
