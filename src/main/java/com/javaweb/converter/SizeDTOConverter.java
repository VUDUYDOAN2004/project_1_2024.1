package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.javaweb.model.SizeDTO;
import com.javaweb.repository.entity.SizeEntity;

@Component
public class SizeDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public SizeEntity toSizeEntity(SizeDTO item) {
		SizeEntity product = modelMapper.map(item, SizeEntity.class);

		return product;
	}
	public SizeDTO toSizeDTO(SizeEntity item) {
		SizeDTO product = modelMapper.map(item, SizeDTO.class);

		return product;
	}
	
	
}
