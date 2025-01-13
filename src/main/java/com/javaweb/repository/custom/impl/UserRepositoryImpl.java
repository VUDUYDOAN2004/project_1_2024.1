package com.javaweb.repository.custom.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.custom.UserRepositoryCustom;
import com.javaweb.repository.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveCustom(UserEntity user) {
        if (user.getUser_id() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public Optional<UserEntity> findByUserNameCustom(String userName) {
        try {
            UserEntity user = (UserEntity) entityManager.createNativeQuery("SELECT * FROM users WHERE user_name = ?", UserEntity.class)
                    .setParameter(1, userName)
                    .getSingleResult();
            return Optional.ofNullable(user);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
