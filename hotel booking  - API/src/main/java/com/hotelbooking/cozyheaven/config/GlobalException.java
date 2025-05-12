package com.hotelbooking.cozyheaven.config;

import java.io.IOException;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelbooking.cozyheaven.exception.BookingNotFoundException;
import com.hotelbooking.cozyheaven.exception.InvalidAnyException;
import com.hotelbooking.cozyheaven.exception.InvalidHotelNameException;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.exception.InvalidStatusException;
import com.hotelbooking.cozyheaven.exception.InvalidUsernameException;

@RestControllerAdvice
public class GlobalException 
{
	@ExceptionHandler(InvalidAnyException.class)
	public ErrorResponse InvalidAnyException(InvalidAnyException e) {
		return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage());
	}
	@ExceptionHandler(InvalidUsernameException.class)
	public ErrorResponse InvalidUsernameExceptionHandler(InvalidUsernameException e) {
		return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage());
	}
	@ExceptionHandler(InvalidIDException.class)
	public ErrorResponse InvalidIDExceptionHandler(InvalidIDException e) {
		return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage());
	}
	@ExceptionHandler(InvalidStatusException.class)
	public ErrorResponse InvalidStatusExceptionHandler(InvalidStatusException e) {
		return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage());
	}
	@ExceptionHandler(InvalidHotelNameException.class)
	public ErrorResponse InvalidHotelNameExceptionHandler(InvalidHotelNameException e) {
		return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage());
	}
	@ExceptionHandler(BookingNotFoundException.class)
	public ErrorResponse InvalidHotelNameExceptionHandler(BookingNotFoundException e) {
		return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage());
	}
	 @ExceptionHandler(RuntimeException.class)
 	 public ErrorResponse invalidImageExceptionHandler(RuntimeException e) {
 		 return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage()); 
 	 }
 	 
 	 @ExceptionHandler(IOException.class)
 	 public ErrorResponse invalidIOExceptionHandler(IOException e) 
 	 {
 		 return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage()); 
 	 }
 	 
 	 @ExceptionHandler(Exception.class)
	 public ErrorResponse exceptionHandler(Exception e)
 	 {
		 return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage()); 
	 }

	
	
	
}
	
