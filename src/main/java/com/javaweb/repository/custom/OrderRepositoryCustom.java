package com.javaweb.repository.custom;

import java.util.List;

import com.javaweb.repository.entity.OrderEntity;
import com.javaweb.repository.entity.UserEntity;

public interface OrderRepositoryCustom {
    List<OrderEntity> findByUser(UserEntity user);
}
