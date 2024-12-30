package com.javaweb.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	public SupplierEntity getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pro_id;
	
	@Column(name="pro_name")
	private String pro_name;
	
	@Column(name="pro_desc")
	private String pro_desc;
	
	@Column(name="pro_quantity")
	private int pro_quantity;
	
	@Column(name="pro_price")
	private int pro_price;
	
	@Column(name="pro_color")
	private String pro_color;
	
	@Column(name="pro_size")
	private String pro_size;
	
	@Column(name="pro_pic")
	private String pro_pic;
	
	@Column(name="pro_status")
	private int pro_status;
	
	@ManyToOne
	@JoinColumn(name="sup_id")
	private SupplierEntity supplier;
	
	
	
	
	
	public Long getPro_id() {
		return pro_id;
	}
	public void setPro_id(Long pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_desc() {
		return pro_desc;
	}
	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}
	public int getPro_quantity() {
		return pro_quantity;
	}
	public void setPro_quantity(int pro_quantity) {
		this.pro_quantity = pro_quantity;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_color() {
		return pro_color;
	}
	public void setPro_color(String pro_color) {
		this.pro_color = pro_color;
	}
	public String getPro_size() {
		return pro_size;
	}
	public void setPro_size(String pro_size) {
		this.pro_size = pro_size;
	}
	public String getPro_pic() {
		return pro_pic;
	}
	public void setPro_pic(String pro_pic) {
		this.pro_pic = pro_pic;
	}
	public int getPro_status() {
		return pro_status;
	}
	public void setPro_status(int pro_status) {
		this.pro_status = pro_status;
	}

}
