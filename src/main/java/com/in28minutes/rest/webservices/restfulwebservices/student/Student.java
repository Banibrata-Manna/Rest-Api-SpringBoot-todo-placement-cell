package com.in28minutes.rest.webservices.restfulwebservices.student;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.in28minutes.rest.webservices.restfulwebservices.jobalerts.Job;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private String id;
	private String enrollmentNumber;
	private String name;
	private String password;
	private String email;
	private long phoneNumber;
	private String program;
	private int graduationYear;
	private String gender;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "student_job",
		joinColumns = @JoinColumn(name = "enrollment_number"),
		inverseJoinColumns = @JoinColumn(name = "job_id")
	)
	@JsonManagedReference
	private Set<Job> appliedJobs;
	public Set<Job> getAppliedJobs() {
		return appliedJobs;
	}
	public void setAppliedJobs(Set<Job> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String enrollmentNumber, String name, String password, String email, long phoneNumber,
			String program, int graduationYear, String gender) {
		super();
		this.id = id;
		this.enrollmentNumber = enrollmentNumber;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.program = program;
		this.graduationYear = graduationYear;
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}
	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public int getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", program=" + program + ", graduationYear=" + graduationYear
				+ ", gender=" + gender + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
