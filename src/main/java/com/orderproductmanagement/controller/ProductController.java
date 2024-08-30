package com.orderproductmanagement.controller;

import java.time.LocalDate;
import java.util.List;

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
import com.orderproductmanagement.entity.Category;
import com.orderproductmanagement.entity.Product;
import com.orderproductmanagement.service.CategoryServiceInterface;
import com.orderproductmanagement.service.ProductServiceInterface;

import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductServiceInterface productService;

	@Autowired
	private CategoryServiceInterface categoryService;

	@PostMapping("/create/{categoryId}")
	public ResponseEntity<?> create(@Valid @RequestBody Product productRequest, @PathVariable Long categoryId) {
		System.out.println("Hello");
		Category category = categoryService.findById(categoryId);

		Product product = new Product();
		product.setTitle(productRequest.getTitle());
		product.setSummary(productRequest.getSummary());
		product.setType(productRequest.getType());
//		product.setCreatedAt(LocalDate.now());
		product.setCategory(category);
		Product newProduct = productService.save(product);
		return new ResponseEntity<>(newProduct, HttpStatus.OK);
	}

	@GetMapping("/getProductList")
	public ResponseEntity<List<Product>> productList() {
		List products = productService.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/getProductDetails/{productId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long productId) {
		return new ResponseEntity<Product>(productService.findById(productId), HttpStatus.OK);
	}

	@PostMapping("/productCreate")
	public ResponseEntity<?> createProduct(@RequestBody Product productRequest) {
		try {
			Category category = categoryService.findById(productRequest.getCategory().getCategoryId());
			Product product = new Product();
			product.setTitle(productRequest.getTitle());
			product.setSummary(productRequest.getSummary());
			product.setType(productRequest.getType());
//			product.setCreatedAt(LocalDate.now());
			product.setCategory(category);
			Product newProduct = productService.save(product);
			return new ResponseEntity<>(newProduct, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			ErrorResponse error = new ErrorResponse("exception is : " + e.getRootCause().getMessage(),
					HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			throw new PersistenceException("Failed in saving product", ex);
		}

	}

}
