package com.orderproductmanagement.service;

import java.util.List;

import com.orderproductmanagement.entity.Category;

public interface CategoryServiceInterface {
	public Category save(Category category);

	public List<Category> findAll();

	public Category findById(Long categoryId);
}
