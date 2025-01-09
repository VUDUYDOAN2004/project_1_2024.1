package com.javaweb.repository.custom;

import java.util.List;

import com.javaweb.model.CartDTO;
import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.entity.CartItemEntity;

public interface CartRepositoryCustom {
//    CartDTO getCart();
    void addCartItem(Long cart_id, Long product_ìd, Long size_id, int quantity);
    void updateCartItem(Long cartItemId, int quantity);
    void removeCartItem(Long cartItemId);
    void checkout( Long cartId);
    public CartEntity getCart(Long cart_id);
}