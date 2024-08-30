package com.orderproductmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderproductmanagement.ControllerAdvice.ErrorResponse;
import com.orderproductmanagement.entity.Item;
import com.orderproductmanagement.entity.Product;
import com.orderproductmanagement.service.ItemServiceInterface;

import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ItemServiceInterface itemService;

	@GetMapping("getItemList")
	public ResponseEntity<List<Item>> getItemList() {
		List items = itemService.findAll();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@PostMapping("create")
	public ResponseEntity<?> createitem(@Valid @RequestBody Item itemRequest) {
		try {
			Item item = new Item();
			item.setTitle(itemRequest.getTitle());
			item.setSummary(itemRequest.getSummary());
			item.setProduct(itemRequest.getProduct());
			item.setBrand(itemRequest.getBrand());
			item.setMrp(itemRequest.getMrp());
			item.setDiscount(itemRequest.getDiscount());
			item.setPrice(itemRequest.getPrice());
			item.setQuantity(itemRequest.getQuantity());
			item.setSold(itemRequest.getSold());
			item.setAvailable(itemRequest.getAvailable());
			item.setDefective(itemRequest.getDefective());
			System.out.println(item.toString());
			itemService.save(item);
			return new ResponseEntity<>("item added successfully", HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			ErrorResponse error = new ErrorResponse("exception is : " + e.getRootCause().getMessage(),
					HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			throw new PersistenceException("Failed in saving item", ex);
		}
	}

	@GetMapping("/getItemDetails/{itemId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long itemId) {
		return new ResponseEntity<Item>(itemService.findById(itemId), HttpStatus.OK);
	}

}
