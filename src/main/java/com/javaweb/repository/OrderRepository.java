package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.custom.OrderRepositoryCustom;
import com.javaweb.repository.entity.OrderEntity;


public interface OrderRepository extends JpaRepository<OrderEntity, Long>, OrderRepositoryCustom {
	 
	 
	
	 

}