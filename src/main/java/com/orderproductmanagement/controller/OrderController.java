package com.orderproductmanagement.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.orderproductmanagement.RequestDTO.OrderRequestDTO;
import com.orderproductmanagement.entity.Item;
import com.orderproductmanagement.entity.Orders;
import com.orderproductmanagement.service.ItemServiceImpl;
import com.orderproductmanagement.service.OrderServiceImpl;

import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;

	@Autowired
	private ItemServiceImpl itemService;

	@GetMapping("/getOrderList")
	public ResponseEntity<List<Orders>> orderList() {
		List orderList = orderService.findAll();
		return new ResponseEntity<>(orderList, HttpStatus.OK);
	}

	@GetMapping("/getOrderDetails/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable Long orderId) {
		return new ResponseEntity<Orders>(orderService.findById(orderId), HttpStatus.OK);
	}

	@PostMapping("/orderCreate")
	public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequestDTO orderRequest) {
		try {

			if (!orderRequest.getOrderItemDetails().isEmpty()) {
				Orders newOrder = new Orders();
				// BigDecimal total,discount;
				Integer lng = 52;
				System.out.println("Hello");
				Set orderDetails = new HashSet<>();
				orderRequest.getOrderItemDetails().forEach(item -> {
					// OrderItemDetails newItemDetails = new OrderItemDetails();
					System.out.println(item.getItem().getItemId());
					System.out.println((itemService.findById(item.getItem().getItemId())).toString());
					// fetch item detail and set item object and product details object
					// Item itemDetails = itemService.findById(item.getItem().getItemId());
//				newItemDetails.setItem(itemDetails);
//				newItemDetails.setProduct(itemDetails.getProduct());
//				
//				
//				newItemDetails.setOrders(newOrder);
					// System.out.println(item.getItem().getItemId());
//				System.out.println(itemService.findById(item.getItem().getItemId()));
					// newOrder.addOrderItemDetails(newItemDetails);
				});
				return new ResponseEntity<>(null, HttpStatus.OK);
			} else {
				throw new PersistenceException("Failed in saving order1");
			}
		} catch (DataIntegrityViolationException e) {
			ErrorResponse error = new ErrorResponse("exception is : " + e.getRootCause().getMessage(),
					HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new PersistenceException("Failed in saving order", ex);
		}

	}

	@GetMapping("/getItemDetails/{itemId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long itemId) {
//		Item item = itemService.findById(itemId);
//		System.out.println(item);
		return new ResponseEntity<Item>(itemService.findById(itemId), HttpStatus.OK);
	}
}
