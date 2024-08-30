package com.orderproductmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderproductmanagement.entity.Item;
import com.orderproductmanagement.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemServiceInterface {

	@Autowired
	private ItemRepository itemRepo;

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return itemRepo.save(item);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemRepo.findAll();
	}

	@Override
	public Item findById(Long itemId) {
		// TODO Auto-generated method stub
		return itemRepo.findById(itemId).get();
	}

}
