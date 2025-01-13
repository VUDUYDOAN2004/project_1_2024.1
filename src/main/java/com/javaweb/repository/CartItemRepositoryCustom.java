package com.javaweb.repository;

import com.javaweb.repository.entity.CartItemEntity;

public interface CartItemRepositoryCustom {
    CartItemEntity findCartItemById(Long cartItemId);
}
