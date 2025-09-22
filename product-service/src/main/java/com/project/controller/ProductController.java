package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ProductRequestDto;
import com.project.dto.ProductResponseDto;
import com.project.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ProductResponseDto addProduct(@RequestBody ProductRequestDto product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/{productId}")
	public ProductResponseDto getProduct(@PathVariable Long productId) {
		return productService.getProductById(productId);
	}
	
	@GetMapping("/exits/{productId}")
	public boolean isProductExits(@PathVariable Long productId) {
		return productService.isProductExits(productId);
	}
	
}