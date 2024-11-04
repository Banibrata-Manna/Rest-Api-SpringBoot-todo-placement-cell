package com.in28minutes.rest.webservices.restfulwebservices.student;

import com.in28minutes.rest.webservices.restfulwebservices.users.UserInterface;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student implements UserInterface {
	@Id
	private String enrollmentNumber;
	private String name;
	private String password;
	private String emailId;
	private long phoneNumber;
	private String program;
	private int graduationYear;
	private String gender;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String enrollmentNumber, String name, String password, String emailId, long phoneNumber,
			String program, int graduationYear, String gender) {
		super();
		this.enrollmentNumber = enrollmentNumber;
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.program = program;
		this.graduationYear = graduationYear;
		this.gender = gender;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return "Student [enrollmentNumber=" + enrollmentNumber + ", name=" + name + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", program=" + program + ", graduationYear=" + graduationYear
				+ ", gender=" + gender + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return enrollmentNumber;
	}
	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "ROLE_STUDENT";
	}	
}
