package com.javaweb.repository.custom;

import com.javaweb.model.CartDTO;

public interface CartRepositoryCustom {
    CartDTO getCart();
    void addCartItem(Long productId, int quantity, Long sizeId);
    void updateCartItem(Long cartItemId, int quantity);
    void removeCartItem(Long cartItemId);
    void checkout( Long cartId);
}