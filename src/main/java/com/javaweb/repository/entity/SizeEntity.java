package com.javaweb.repository.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name = "sizes")
public class SizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long size_id;
    
    @Column(name="size_name")
    private String size_name;

    @ManyToMany(mappedBy = "sizes", fetch = FetchType.LAZY)
	private List<ProductEntity> products = new ArrayList<>();
    
    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    private List<CartItemEntity> cartItems = new ArrayList<>();
    
    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    private List<OrderItemEntity> orderItems = new ArrayList<>();

	

	

	public Long getSize_id() {
		return size_id;
	}

	public void setSize_id(Long size_id) {
		this.size_id = size_id;
	}

	public String getSize_name() {
		return size_name;
	}

	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public List<CartItemEntity> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemEntity> cartItems) {
		this.cartItems = cartItems;
	}

	public List<OrderItemEntity> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemEntity> orderItems) {
		this.orderItems = orderItems;
	}
    

	

	

    
}