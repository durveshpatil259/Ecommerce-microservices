package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.CartItemRequestDto;
import com.project.dto.CartItemResponseDTO;
import com.project.service.CartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CartItemResponseDTO addItemToCart(@RequestBody CartItemRequestDto request) {
		return cartService.addToCart(request);
	}
	
	@PutMapping
	public CartItemResponseDTO updateQuanity(@RequestBody CartItemRequestDto request) {
		return cartService.updateQuanity(request);
	}
	
	@GetMapping("/{userId}")
	public List<CartItemResponseDTO> getCartByUserId(@PathVariable Long userId) {
		return cartService.getUserCart(userId);
	}
	
	@DeleteMapping("/clear/{userId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void clearUserCart(@PathVariable Long userId) {
		cartService.clearCart(userId);
	}
	
	// combination of path variable and request param
	@DeleteMapping("/remove/{productId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeItemFromCart(@PathVariable Long product,@RequestParam Long userId) {
		cartService.removeItem(userId, product);
	}
	
}
