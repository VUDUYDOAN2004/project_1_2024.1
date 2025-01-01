package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.CartItemDTO;

import com.javaweb.repository.entity.CartItemEntity;


@Component
public class CartItemDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public CartItemDTO toProductDTO(CartItemEntity item) {
		CartItemDTO product = modelMapper.map(item, CartItemDTO.class);

		return product;
	}
}
