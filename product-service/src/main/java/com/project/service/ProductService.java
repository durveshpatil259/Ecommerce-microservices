package com.project.service;

import com.project.dto.ProductRequestDto;
import com.project.dto.ProductResponseDto;

public interface ProductService {

	ProductResponseDto addProduct(ProductRequestDto productRequestDto);
	
	boolean isProductExits(Long productId);
	
	ProductResponseDto getProductById(Long productId);
}
