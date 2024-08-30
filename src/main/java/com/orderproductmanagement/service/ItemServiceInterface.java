package com.orderproductmanagement.service;

import java.util.List;

import com.orderproductmanagement.entity.Item;

public interface ItemServiceInterface {

	public Item save(Item item);

	public List<Item> findAll();

	public Item findById(Long itemId);
}
