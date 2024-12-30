package com.javaweb.repository.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AdminEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_username",nullable = false, unique = true)
    private String adminUsername;

    @Column(name = "admin_password",nullable = false)
    private String adminPassword;

    @Column(name = "admin_firstname")
    private String adminFirstname;

    @Column(name = "admin_lastname")
    private String adminLastname;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "admin_phone")
    private String adminPhone;

    @Column(name = "admin_address")
    private String adminAddress;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminFirstname() {
		return adminFirstname;
	}

	public void setAdminFirstname(String adminFirstname) {
		this.adminFirstname = adminFirstname;
	}

	public String getAdminLastname() {
		return adminLastname;
	}

	public void setAdminLastname(String adminLastname) {
		this.adminLastname = adminLastname;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
    
}
