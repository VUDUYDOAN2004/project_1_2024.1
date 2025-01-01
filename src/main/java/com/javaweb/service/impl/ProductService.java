package com.javaweb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.ProductDTOConverter;
import com.javaweb.model.ProductDTO;
import com.javaweb.repository.ProductRepository;
import com.javaweb.repository.entity.ProductEntity;


@Service
public class ProductService  {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductDTOConverter productDTOConverter;
	

	public List<ProductDTO> findAll() {
		List<ProductEntity> productEntities = productRepository.findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(ProductEntity item: productEntities) {
			ProductDTO product = productDTOConverter.toProductDTO(item);
			result.add(product);
		}
		return result;
	}
	
	public List<ProductDTO> findByPrice(BigDecimal minprice, BigDecimal maxprice) {
		List<ProductEntity> productEntities = productRepository.findByPrice(minprice, maxprice);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(ProductEntity item: productEntities) {
			ProductDTO product = productDTOConverter.toProductDTO(item);
			result.add(product);
		}
		return result;
	}
	public List<ProductDTO> findByName(String name) {
		List<ProductEntity> productEntities = productRepository.findByName(name);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(ProductEntity item: productEntities) {
			ProductDTO product = productDTOConverter.toProductDTO(item);
			result.add(product);
		}
		return result;
	}
	public List<ProductDTO> findByCategory(String category) {
		List<ProductEntity> productEntities = productRepository.findByCategory(category);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(ProductEntity item: productEntities) {
			ProductDTO product = productDTOConverter.toProductDTO(item);
			result.add(product);
		}
		return result;
	}
	
	public List<ProductDTO> findBySize(String size) {
		List<ProductEntity> productEntities = productRepository.findBySize(size);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(ProductEntity item: productEntities) {
			ProductDTO product = productDTOConverter.toProductDTO(item);
			result.add(product);
		}
		return result;
	}
	public List<ProductDTO> findByFilter(BigDecimal minprice, BigDecimal maxprice, String size) {
		if (minprice == null) minprice = BigDecimal.ZERO;
	    if (maxprice == null) maxprice = BigDecimal.valueOf(Long.MAX_VALUE);
	    List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
	    if(size == null || size.isEmpty())	
	    	 productEntities = productRepository.findByPrice(minprice, maxprice);
	    else
	    	 productEntities = productRepository.findByFilter(minprice, maxprice, size);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for(ProductEntity item: productEntities) {
			ProductDTO product = productDTOConverter.toProductDTO(item);
			result.add(product);
		}
		return result;
	}
	
	
	
	
}
