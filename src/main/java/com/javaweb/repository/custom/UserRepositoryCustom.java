package com.javaweb.repository.custom;

import java.util.Optional;

import com.javaweb.repository.entity.UserEntity;

public interface UserRepositoryCustom {
    void saveCustom(UserEntity user);
    Optional<UserEntity> findByUserNameCustom(String userName);
}
