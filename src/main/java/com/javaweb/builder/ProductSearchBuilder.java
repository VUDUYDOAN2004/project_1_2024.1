package com.javaweb.builder;

public class ProductSearchBuilder {
	private int pro_id;
	private String pro_name;
	private String pro_desc;
	private int pro_quantity;
	private int pro_price;
	private String pro_color;
	private String pro_size;
	private String pro_pic;
	private int pro_status;
	private int sup_id;
	
	private ProductSearchBuilder(Builder builder) {
		this.pro_id = builder.pro_id;
		this.pro_name = builder.pro_name;
		this.pro_desc = builder.pro_desc;
		this.pro_quantity = builder.pro_quantity;
		this.pro_price = builder.pro_price;
		this.pro_color = builder.pro_color;
		this.pro_size = builder.pro_size;
		this.pro_pic = builder.pro_pic;
		this.pro_status = builder.pro_status;
		this.sup_id = builder.sup_id;
	}
	
	public int getPro_id() {
		return pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public String getPro_desc() {
		return pro_desc;
	}
	public int getPro_quantity() {
		return pro_quantity;
	}
	public int getPro_price() {
		return pro_price;
	}
	public String getPro_color() {
		return pro_color;
	}
	public String getPro_size() {
		return pro_size;
	}
	public String getPro_pic() {
		return pro_pic;
	}
	public int getPro_status() {
		return pro_status;
	}
	public int getSup_id() {
		return sup_id;
	}
	
	public static class Builder{
		private int pro_id;
		private String pro_name;
		private String pro_desc;
		private int pro_quantity;
		private int pro_price;
		private String pro_color;
		private String pro_size;
		private String pro_pic;
		private int pro_status;
		private int sup_id;
		
		public void setPro_id(int pro_id) {
			this.pro_id = pro_id;
		}
		public void setPro_name(String pro_name) {
			this.pro_name = pro_name;
		}
		public void setPro_desc(String pro_desc) {
			this.pro_desc = pro_desc;
		}
		public void setPro_quantity(int pro_quantity) {
			this.pro_quantity = pro_quantity;
		}
		public void setPro_price(int pro_price) {
			this.pro_price = pro_price;
		}
		public void setPro_color(String pro_color) {
			this.pro_color = pro_color;
		}
		public void setPro_size(String pro_size) {
			this.pro_size = pro_size;
		}
		public void setPro_pic(String pro_pic) {
			this.pro_pic = pro_pic;
		}
		public void setPro_status(int pro_status) {
			this.pro_status = pro_status;
		}
		public void setSup_id(int sup_id) {
			this.sup_id = sup_id;
		}
		
		public ProductSearchBuilder build() {
			return new ProductSearchBuilder(this);
		}
		
	}
	
}
