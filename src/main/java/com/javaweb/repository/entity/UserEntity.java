package com.javaweb.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserID;

    @Column(name = "Username", nullable = false, unique = true)
    private String Username;

    @Column(name = "PasswordHash", nullable = false)
    private String PasswordHash;

    @Column(name = "FullName")
    private String FullName;

    @Column(name = "Email", nullable = false, unique = true)
    private String Email;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

    @Column(name = "Address")
    private String Address;
    
    

	
    
    
}
