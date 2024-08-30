package com.orderproductmanagement.service;

import java.util.List;

import com.orderproductmanagement.entity.Product;

public interface ProductServiceInterface {
	public Product save(Product product);

	public List<Product> findAll();

	public Product findById(Long productId);

}
