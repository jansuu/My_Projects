package com.hotelbooking.cozyheaven.exception;

public class InvalidAnyException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidAnyException(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	} 

}
