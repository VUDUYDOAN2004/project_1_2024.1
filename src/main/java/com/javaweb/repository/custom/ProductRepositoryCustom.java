package com.javaweb.repository.custom;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.entity.ProductEntity;


public interface ProductRepositoryCustom {
	List<ProductEntity> findByName(String name);
	List<ProductEntity> findByCategory(String category);
	List<ProductEntity> findByPrice(BigDecimal minprice, BigDecimal maxprice);
	List<ProductEntity> findBySize(String size);
	List<ProductEntity> findByFilter(BigDecimal minprice, BigDecimal maxprice, String size);


}
