package com.orderproductmanagement.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderproductmanagement.RequestDTO.CategoryRequestDTO;
import com.orderproductmanagement.entity.Category;
import com.orderproductmanagement.entity.Product;
import com.orderproductmanagement.repository.CategoryRepository;
import com.orderproductmanagement.repository.ProductRepository;
import com.orderproductmanagement.service.CategoryServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private CategoryServiceInterface categoryService;

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody CategoryRequestDTO categoryRequest) {
		Category category = new Category();
		category.setTitle(categoryRequest.getTitle());
		category.setContent(categoryRequest.getContent());
		System.out.println(category.toString());
		return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);

	}

	@GetMapping("/getCategoryList")
	public ResponseEntity<List<Category>> categoryList() {
		List categories = categoryService.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);

	}
}
