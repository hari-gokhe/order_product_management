package com.orderproductmanagement.ControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.PersistenceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.UnexpectedTypeException;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
//		System.out.println("NoSuchElementException");
//		ErrorResponse dataException = new ErrorResponse("Data Not Found In DB", HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<Object>(dataException, HttpStatus.NOT_FOUND);
//	}

//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
//		System.out.println("DataIntegrityViolationException error {} : " + ex.getRootCause());
//		ErrorResponse dataException = new ErrorResponse(ex.getRootCause().toString(),
//				HttpStatus.INTERNAL_SERVER_ERROR.value());
//		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

//	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//	public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(
//			SQLIntegrityConstraintViolationException ex) {
//		System.out.println("SQLIntegrityConstraintViolationException error is {} : " + ex.getSQLState());
//		ErrorResponse dataException = new ErrorResponse(ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR.value());
//		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	@ExceptionHandler(PersistenceException.class)
//	public ResponseEntity<Object> handlePersistenceException(PersistenceException ex) {
//		System.out.println("PersistenceException error is {} : " + ex.getMessage());
//		ErrorResponse dataException = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
//		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	@ExceptionHandler(UnexpectedTypeException.class)
//	public ResponseEntity<Object> handleUnexpectedTypeException(UnexpectedTypeException ex) {
//		System.out.println("UnexpectedTypeException error is {} : " + ex);
//		ErrorResponse dataException = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
//		return new ResponseEntity<Object>(dataException, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	

	 
}
