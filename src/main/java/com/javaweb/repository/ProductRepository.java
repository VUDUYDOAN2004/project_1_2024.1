package com.javaweb.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaweb.repository.custom.ProductRepositoryCustom;
import com.javaweb.repository.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, ProductRepositoryCustom {
	 
	 
	
	 

}
