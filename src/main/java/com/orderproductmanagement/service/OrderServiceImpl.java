package com.orderproductmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderproductmanagement.entity.Orders;
import com.orderproductmanagement.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderServiceInterface {
	@Autowired
	private OrdersRepository orderRepo;

	@Override
	public Orders save(Orders order) {
		return orderRepo.save(order);
	}

	@Override
	public List<Orders> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public Orders findById(Long orderId) {
		return orderRepo.findById(orderId).get();
	}

}
