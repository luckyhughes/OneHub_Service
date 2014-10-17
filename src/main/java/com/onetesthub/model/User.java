package com.onetesthub.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "USERS")
public class User{

	 @Id
	 @Column(name = "user_id")
	 @GeneratedValue
	 private Integer id;
	
	@Column(name = "FIRSTNAME", nullable = false)
	String firstName;

	@Column(name = "LASTNAME", nullable = false)
	String lastName;

	@Column(name = "USERNAME", unique = true, nullable = false)
	String username;

	@Column(name = "PASSWORD", nullable = false)
	String password;

	@Column(name = "COMPANY", nullable = false)
	String company;

	@Column(name = "PHONE", unique = true, nullable = false)
	String phone;

	@Column(name = "EMAIL", unique = true, nullable = false)
	String email;

	@Column(name = "COUNTRY")
	String country;

	@Column(name = "ENABLED", nullable = false, columnDefinition = "boolean default true")
	private boolean enabled;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<UserRole> userRole;

	public User() {
	}
	
	private void associateRolesWithUser(){
	    for(UserRole urole : userRole) urole.setUser(this);
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

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
		
		for(UserRole role : userRole) {
			role.setUser(this);
		}
	}

}
