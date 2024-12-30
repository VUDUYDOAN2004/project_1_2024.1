package com.javaweb.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    private Long sup_id;

	    @Column(name = "sup_name") 
	    private String name;

	    @Column(name = "sup_email") 
	    private String email;

	    @Column(name = "sup_phone") 
	    private String phone;

	    @Column(name = "sup_address") 
	    private String address;
	    
	    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
	    private List<ProductEntity> products;

		

		public Long getSup_id() {
			return sup_id;
		}

		public void setSup_id(Long sup_id) {
			this.sup_id = sup_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<ProductEntity> getProducts() {
			return products;
		}

		public void setProducts(List<ProductEntity> products) {
			this.products = products;
		}
	
}
