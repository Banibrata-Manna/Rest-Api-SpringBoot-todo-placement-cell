package com.in28minutes.rest.webservices.restfulwebservices.hods;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hod {
	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private String department;
	public Hod() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hod(String id, String name, String email, String password, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.department = department;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Hod [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", department="
				+ department + "]";
	}
}
