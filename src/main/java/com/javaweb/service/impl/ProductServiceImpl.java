package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.ProductDTOConverter;
import com.javaweb.model.ProductDTO;
import com.javaweb.repository.ProductRepository;
import com.javaweb.repository.entity.ProductEntity;
import com.javaweb.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductDTOConverter productDTOConverter;
	
	@Override
	public List<ProductDTO> findAll() {
		List<ProductEntity> productEntities = productRepository.findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(ProductEntity item: productEntities) {
			ProductDTO product = productDTOConverter.toProductDTO(item);
			result.add(product);
		}
		return result;
	}
	
}
