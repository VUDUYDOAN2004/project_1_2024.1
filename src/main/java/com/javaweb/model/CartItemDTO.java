package com.javaweb.model;

import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.entity.SizeEntity;

public class CartItemDTO {
    private Long cart_item_id;
    private CartDTO cart;
    private ProductDTO product;
    private SizeDTO size;
    private int quantity;


    
	public Long getCart_item_id() {
		return cart_item_id;
	}
	public void setCart_item_id(Long cart_item_id) {
		this.cart_item_id = cart_item_id;
	}
	
	public CartDTO getCart() {
		return cart;
	}
	public void setCart(CartDTO cart) {
		this.cart = cart;
	}
	public void setSize(SizeDTO size) {
		this.size = size;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
	public SizeDTO getSize() {
		return size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
   
   
}