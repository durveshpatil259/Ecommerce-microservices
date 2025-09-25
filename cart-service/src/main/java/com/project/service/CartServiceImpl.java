package com.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.CartItemRequestDto;
import com.project.dto.CartItemResponseDTO;
import com.project.model.CartItem;
import com.project.repository.CartItemRepository;

import jakarta.transaction.Transactional;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public CartItemResponseDTO addToCart(CartItemRequestDto request) {
		
		// TODO : product services api need to call to fetch product information
		// RestTempalte
		
		// TODO : user service api need to call to fetch user details
		
		CartItem cartItem = new CartItem();
		BeanUtils.copyProperties(request, cartItem);
		CartItem dbCartItem = cartItemRepository.save(cartItem);
		
		return mapToResponseDto(dbCartItem);
	}

	private CartItemResponseDTO mapToResponseDto(CartItem dbCartItem) {
		CartItemResponseDTO response = new CartItemResponseDTO();
		BeanUtils.copyProperties(dbCartItem, response);
		return response;
	}

	@Override
	public List<CartItemResponseDTO> getUserCart(Long userId) {
		return cartItemRepository.findByUserId(userId).stream()
				.map(this::mapToResponseDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void removeItem(Long userId, Long productId) {
		// TODO Auto-generated method stub
		cartItemRepository.deleteByUserIdAndProductId(userId, productId);
	}

	@Override
	public CartItemResponseDTO updateQuanity(CartItemRequestDto request) {
		// userid and productid
		CartItem cartItem  = cartItemRepository.findByUserIdAndProductId(request.getUserId(), request.getProductId())
		 .orElseThrow(() -> new RuntimeException("Item not in the cart"));
		cartItem.setQuantity(request.getQuantity());
		CartItem dbCart = cartItemRepository.save(cartItem);
		
		return mapToResponseDto(dbCart);
	}

	@Override
	@Transactional
	public void clearCart(Long userId) {
		// TODO Auto-generated method stub
		cartItemRepository.deleteByUserId(userId);
	}
	
	
}
