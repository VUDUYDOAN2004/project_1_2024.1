package com.project1.shoppingwebsite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project1.shoppingwebsite.model.Product;
import com.project1.shoppingwebsite.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Product getProductById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}