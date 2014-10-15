package com.onetesthub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
	
	@Column(name="FIRSTNAME",nullable=false)
	String firstName;
	
	@Column(name="LASTNAME",nullable=false)
	String lastName;
	
	@Column(name="USERNAME", unique = true, nullable=false)
	String username;
	
	@Column(name="PASSWORD", nullable=false)
	String password;
	
	@Column(name="COMPANY",nullable=false)
	String company;
	
	@Column(name="PHONE", unique = true, nullable=false)
	String phone;
	
	@Column(name="EMAIL", unique = true, nullable=false)
	String email;
	
	@Column(name="COUNTRY")
	String country;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
