package com.hotelbooking.cozyheaven.exception;

public class InvalidHotelNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3453942163247697949L;
	private String message;
	public InvalidHotelNameException(String message) {
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
