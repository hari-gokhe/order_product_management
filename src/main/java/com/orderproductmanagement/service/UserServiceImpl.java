package com.orderproductmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderproductmanagement.entity.User;
import com.orderproductmanagement.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserServiceInterface{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User findById(Long userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId).get();
	}

}
