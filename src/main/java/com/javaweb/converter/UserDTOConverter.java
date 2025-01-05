package com.javaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.UserDTO;
import com.javaweb.repository.entity.UserEntity;




@Component
public class UserDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO toProductDTO(UserEntity item) {
		UserDTO product = modelMapper.map(item, UserDTO.class);

		return product;
	}
}
