package com.orderproductmanagement.service;

import java.util.List;

import com.orderproductmanagement.entity.Orders;

public interface OrderServiceInterface {
	public Orders save(Orders order);

	public List<Orders> findAll();

	public Orders findById(Long orderId);

}
