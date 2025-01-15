package com.javaweb.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.javaweb.repository.custom.CartItemRepositoryCustom;
import com.javaweb.repository.entity.CartItemEntity;

public class CartItemRepositoryImpl implements CartItemRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CartItemEntity findCartItemById(Long cartItemId) {
        TypedQuery<CartItemEntity> query = entityManager.createQuery(
            "SELECT c FROM CartItemEntity c WHERE c.cart_item_id = :cartItemId", CartItemEntity.class);
        query.setParameter("cartItemId", cartItemId);
        return query.getSingleResult();
    }
}
