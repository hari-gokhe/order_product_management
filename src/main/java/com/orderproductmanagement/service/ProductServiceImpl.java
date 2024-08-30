package com.orderproductmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderproductmanagement.entity.Product;
import com.orderproductmanagement.repository.CategoryRepository;
import com.orderproductmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServiceInterface {
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product findById(Long productId) {
		return productRepo.findById(productId).get();
	}

}
