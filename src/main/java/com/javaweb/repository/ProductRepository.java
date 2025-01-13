package com.javaweb.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.custom.ProductRepositoryCustom;
import com.javaweb.repository.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, ProductRepositoryCustom {
	 
	 
	
	 

}
