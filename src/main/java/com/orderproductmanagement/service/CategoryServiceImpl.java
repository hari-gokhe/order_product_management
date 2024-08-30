package com.orderproductmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderproductmanagement.entity.Category;
import com.orderproductmanagement.repository.CategoryRepository;
import com.orderproductmanagement.repository.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Category save(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category findById(Long categoryId) {
		return categoryRepo.findById(categoryId).get();
	}
}
