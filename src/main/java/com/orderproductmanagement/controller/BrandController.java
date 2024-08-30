package com.orderproductmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderproductmanagement.entity.Brand;
import com.orderproductmanagement.repository.BrandRepository;
import com.orderproductmanagement.service.BrandServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("brand")
public class BrandController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BrandServiceInterface brandService;

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody Brand brandRequest) {
		Brand brand = new Brand();
		brand.setTitle(brandRequest.getTitle());
		brand.setSummary(brandRequest.getSummary());
//		brand.setCreatedAt(LocalDate.now());
		System.out.println(brand.toString());
		return new ResponseEntity<>(brandService.save(brand), HttpStatus.OK);

	}

	@GetMapping("/getBrandList")
	public ResponseEntity<List<Brand>> productList() {
		List brands = brandService.findAll();
		return new ResponseEntity<>(brands, HttpStatus.OK);

	}

}
