package com.javaweb.repository.custom;

import com.javaweb.repository.entity.CartItemEntity;

public interface CartItemRepositoryCustom {
    CartItemEntity findCartItemById(Long cartItemId);
}
