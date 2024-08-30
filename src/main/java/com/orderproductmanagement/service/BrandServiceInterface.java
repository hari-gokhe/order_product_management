package com.orderproductmanagement.service;

import java.util.List;

import com.orderproductmanagement.entity.Brand;

public interface BrandServiceInterface {
	public Brand save(Brand brand);

	public List<Brand> findAll();

}
