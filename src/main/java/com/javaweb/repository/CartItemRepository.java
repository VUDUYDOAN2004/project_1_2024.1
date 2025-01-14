package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.custom.CartItemRepositoryCustom;
import com.javaweb.repository.entity.CartItemEntity;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Long>, CartItemRepositoryCustom {
    // ...existing code...
}
