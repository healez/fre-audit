package com.myspace.githook_1;

public class TryLog {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "[" + message + "]";
	}
	
	

}
