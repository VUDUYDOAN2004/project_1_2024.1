package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.ProductDTO;
import com.javaweb.repository.entity.ProductEntity;

@Component
public class ProductDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProductDTO toProductDTO(ProductEntity item) {
		ProductDTO product = modelMapper.map(item, ProductDTO.class);

		return product;
	}
}
