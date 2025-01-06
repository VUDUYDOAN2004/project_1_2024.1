package com.javaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.CartDTO;
import com.javaweb.repository.custom.CartRepositoryCustom;

@Service
public class CartService {

    @Autowired
    private CartRepositoryCustom cartRepository;

    public CartDTO getCart() {
        return cartRepository.getCart();
    }

    public void addToCart(Long productId, int quantity, Long sizeId) {
        cartRepository.addCartItem(productId, quantity, sizeId);
    }

    public void updateCartItem(Long cartItemId, int quantity) {
        cartRepository.updateCartItem(cartItemId, quantity);
    }

    public void removeCartItem(Long cartItemId) {
        cartRepository.removeCartItem(cartItemId);
    }

    public void checkout(Long cartId) {
        cartRepository.checkout(cartId);
    }
}