package com.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.ProductRequestDto;
import com.project.dto.ProductResponseDto;
import com.project.models.Product;
import com.project.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productRequestDto, product);
		
		Product dbProduct = productRepository.save(product);
		return mapToDto(dbProduct);
	}
	
	
	public ProductResponseDto mapToDto(Product product) {
		ProductResponseDto response = new ProductResponseDto();
		BeanUtils.copyProperties(product, response);
		return response;
	}

	@Override
	public boolean isProductExits(Long productId) {
		return productRepository.existsById(productId);
	}

	@Override
	public ProductResponseDto getProductById(Long productId) {
		return productRepository.findById(productId)
				.map(p -> mapToDto(p)) // ::
				.orElseThrow(() -> new RuntimeException("Product Not Found in DB"));
	}

	
	
}
