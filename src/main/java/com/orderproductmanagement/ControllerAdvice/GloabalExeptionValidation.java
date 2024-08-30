package com.orderproductmanagement.ControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.PersistenceException;
import jakarta.validation.UnexpectedTypeException;

@RestControllerAdvice
public class GloabalExeptionValidation {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String field = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(field, message);
		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
		System.out.println("NoSuchElementException");
		ErrorResponse dataException = new ErrorResponse("Data Not Found In DB", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Object>(dataException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		System.out.println("DataIntegrityViolationException error {} : " + ex.getRootCause());
		ErrorResponse dataException = new ErrorResponse(ex.getRootCause().getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(
			SQLIntegrityConstraintViolationException ex) {
		System.out.println("SQLIntegrityConstraintViolationException error is {} : " + ex.getSQLState());
		ErrorResponse dataException = new ErrorResponse(ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PersistenceException.class)
	public ResponseEntity<Object> handlePersistenceException(PersistenceException ex) {
		System.out.println("PersistenceException error is {} : " + ex.getMessage());
		ErrorResponse dataException = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Object> handleUnexpectedTypeException(UnexpectedTypeException ex) {
		System.out.println("UnexpectedTypeException error is {} : " + ex);
		ErrorResponse dataException = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
