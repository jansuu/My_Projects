package com.hotelbooking.cozyheaven.config;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.exception.InvalidStatusException;
import com.hotelbooking.cozyheaven.exception.InvalidUsernameException;

@RestControllerAdvice
public class GlobalException {
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

}
