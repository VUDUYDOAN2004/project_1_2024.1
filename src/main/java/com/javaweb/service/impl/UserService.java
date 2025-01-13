package com.javaweb.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaweb.repository.CartRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.entity.UserEntity;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserEntity user) {
        
        if (userRepository.findByUserName(user.getUser_name()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword_hash(passwordEncoder.encode(user.getPassword_hash()));
        
        
        userRepository.saveCustom(user);
        
        
        CartEntity cart = new CartEntity();
        cart.setUser(user);
        cartRepository.save(cart);
        
        
        user.setCart(cart);
        
       
        userRepository.saveCustom(user);
    }

    public UserEntity findUserByUserName(String userName) {
        return userRepository.findByUserName(userName).orElse(null);
    }
}