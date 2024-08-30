package com.orderproductmanagement.error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException  {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationHandler(MethodArgumentNotValidException exception) {
		HashMap<String, Object> resObj = new HashMap<>();
		List<String> errorDetails = new ArrayList<>();
		if (exception.getErrorCount() > 0) {
			for (ObjectError error : exception.getBindingResult().getAllErrors()) {
				errorDetails.add(error.getDefaultMessage());
			}
		}
		resObj.put("error", "Field Validation Errors");
		resObj.put("status", HttpStatus.BAD_REQUEST.value());
		resObj.put("filedError", errorDetails);
		return new ResponseEntity<>(resObj, HttpStatus.OK);
	}
	
	
	
	
}
