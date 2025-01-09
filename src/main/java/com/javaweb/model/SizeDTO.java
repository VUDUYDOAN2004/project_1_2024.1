package com.javaweb.model;

import java.util.ArrayList;
import java.util.List;


import com.javaweb.repository.entity.CartItemEntity;
import com.javaweb.repository.entity.OrderItemEntity;
import com.javaweb.repository.entity.ProductEntity;

public class SizeDTO {
	
	private Long size_id;
    private String size_name;

	
    
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

	

	
    
    
}
