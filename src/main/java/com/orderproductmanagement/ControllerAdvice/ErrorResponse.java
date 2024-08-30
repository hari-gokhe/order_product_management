package com.orderproductmanagement.ControllerAdvice;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	public final String message;
	public final int httpStatus;
	public ErrorResponse(String message, int httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	
	
	
	
	
	
}
