package com.project1.shoppingwebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.shoppingwebsite.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String keyword);
}