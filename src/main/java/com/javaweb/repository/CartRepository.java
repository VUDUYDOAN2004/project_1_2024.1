package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.repository.custom.CartRepositoryCustom;
import com.javaweb.repository.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long>, CartRepositoryCustom {
    
}
