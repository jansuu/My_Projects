package com.hotelbooking.cozyheaven.exception;

public class InvalidStatusException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6158257469108937791L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidStatusException(String message) {
		super();
		this.message = message;
	}
}
