package com.lpu.EmployeeApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "name should not be blank")
	private String name;
	
	//@Positive(message="phone number should be positive")
	private long phone;
	
	//@Min(value=18, message="age must be above 18")
	//@Max(value=60, message="age must be below 60")
	private int age;
	
	//NotBlank(message="email should not be blank")
	//@Email(message="invalid mail format")
	//@Pattern(regexp="")
	//private String email;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Company company;
	
	public int getId() {
		return id;
	}
	
	
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee() {
		super();
	}
	
	
	
	

}
