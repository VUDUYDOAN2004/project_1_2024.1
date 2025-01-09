package com.javaweb.repository;

import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.entity.CartItemEntity;
import com.javaweb.repository.custom.CartRepositoryCustom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long>, CartRepositoryCustom {
    // Các phương thức truy vấn khác (nếu cần)
//	List<CartItemEntity> findByCartId(Long cartId);
}