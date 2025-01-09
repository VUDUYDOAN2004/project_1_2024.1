package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.CartDTO;
import com.javaweb.model.CartItemDTO;
import com.javaweb.model.ProductDTO;
import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.entity.CartItemEntity;
import com.javaweb.repository.entity.ProductEntity;

@Component
public class CartDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public CartItemDTO toCartItemDTO(CartItemEntity item) {
		CartItemDTO cartitem = modelMapper.map(item, CartItemDTO.class);

		return cartitem;
	}
	public CartItemEntity toCartItemEntity(CartItemDTO item) {
		CartItemEntity cartitem = modelMapper.map(item, CartItemEntity.class);

		return cartitem;
	}
	public CartDTO toCartDTO(CartEntity item) {
		CartDTO cartitem = modelMapper.map(item, CartDTO.class);

		return cartitem;
	}
	
}
