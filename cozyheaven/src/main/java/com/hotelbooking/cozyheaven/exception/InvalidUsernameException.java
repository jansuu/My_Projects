package com.hotelbooking.cozyheaven.exception;

public class InvalidUsernameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9162670718413635075L;
	
	
	private String message;


	public InvalidUsernameException(String message) {
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
