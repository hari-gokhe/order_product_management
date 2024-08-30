package com.orderproductmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderproductmanagement.ControllerAdvice.ErrorResponse;
import com.orderproductmanagement.RequestDTO.UserRequestDTO;
import com.orderproductmanagement.entity.User;
import com.orderproductmanagement.service.UserServiceImpl;

import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServiceImpl userservice;

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDTO userRequest) {
		try {
			User user = new User();
			user.setFirstName(userRequest.getFirstName());
			user.setLastName(userRequest.getLastName());
			user.setUserName(userRequest.getUserName());
			user.setMobile(userRequest.getMobile());
			user.setEmail(userRequest.getEmail());
			return new ResponseEntity<>(userservice.save(user), HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			ErrorResponse error = new ErrorResponse("exception is : " + e.getRootCause().getMessage(),
					HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			System.out.println("error is : {} ");
			throw new PersistenceException(e);
		}

	}

	@GetMapping("getUserDetails/{userId}")
	public ResponseEntity<?> getUserDetails(@PathVariable Long userId) {
		return new ResponseEntity<User>(userservice.findById(userId), HttpStatus.OK);
	}

	@GetMapping("getUserList")
	public ResponseEntity<List<User>> getUserList() {
		return new ResponseEntity<>(userservice.findAll(), HttpStatus.OK);
	}
	
}
