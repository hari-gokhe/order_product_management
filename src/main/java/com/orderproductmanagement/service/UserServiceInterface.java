package com.orderproductmanagement.service;

import java.util.List;

import com.orderproductmanagement.entity.User;

public interface UserServiceInterface {
	public List<User> findAll();

	public User save(User user);
	
	public User findById(Long userId);
}
