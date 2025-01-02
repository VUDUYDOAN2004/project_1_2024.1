package com.javaweb.repository.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductSizeId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long productId;

    private Long sizeId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

    
}