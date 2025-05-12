package com.hotelbooking.cozyheaven.exception;

public class InvalidIDException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9162670718413635075L;
	
	private String message;

	public InvalidIDException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
