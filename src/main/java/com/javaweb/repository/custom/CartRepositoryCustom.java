package com.javaweb.repository.custom;

import com.javaweb.repository.entity.CartEntity;

public interface CartRepositoryCustom {
//    CartDTO getCart();
    void addCartItem(Long cart_id, Long product_id, Long size_id, int quantity);
    void updateCartItem(Long cartItemId, int quantity);
    void removeCartItem(Long cartItemId);
    void checkout( Long cartId);
    public CartEntity getCart(Long cart_id);
}