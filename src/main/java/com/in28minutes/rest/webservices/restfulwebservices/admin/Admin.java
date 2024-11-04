package com.in28minutes.rest.webservices.restfulwebservices.admin;

import com.in28minutes.rest.webservices.restfulwebservices.users.UserInterface;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin implements UserInterface {
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	public Admin() {
		
	}
	public Admin(String id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "ROLE_ADMIN";
	}
	
}
