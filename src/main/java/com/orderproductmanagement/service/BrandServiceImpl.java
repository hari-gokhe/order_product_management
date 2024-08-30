package com.orderproductmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderproductmanagement.entity.Brand;
import com.orderproductmanagement.repository.BrandRepository;
import com.orderproductmanagement.repository.CategoryRepository;
import com.orderproductmanagement.repository.ProductRepository;

@Service
public class BrandServiceImpl implements BrandServiceInterface {

	@Autowired
	private BrandRepository brandRepo;

	@Override
	public Brand save(Brand brand) {
		return brandRepo.save(brand);
	}

	@Override
	public List<Brand> findAll() {
		return brandRepo.findAll();
	}
}
