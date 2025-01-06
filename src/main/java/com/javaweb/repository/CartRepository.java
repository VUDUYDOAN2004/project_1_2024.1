package com.javaweb.repository;

import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.custom.CartRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long>, CartRepositoryCustom {
    // Các phương thức truy vấn khác (nếu cần)
}