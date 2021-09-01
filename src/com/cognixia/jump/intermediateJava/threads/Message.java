package com.cognixia.jump.intermediateJava.threads;

//create object that will have a lock when called by wait and notifier threads
public class Message {
	
	private String msg;

	public Message(String msg) {
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
