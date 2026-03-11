package com.lpu.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true)
	private String name;
	private String email;
	private String course;
	private int marks;
	@Lob
	private byte[] profile_image;
	
	@Lob
	private byte[] assignmentFile;
	
	private String role;
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public byte[] getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(byte[] profile_image) {
		this.profile_image = profile_image;
	}

	public byte[] getAssignmentFile() {
		return assignmentFile;
	}

	public void setAssignmentFile(byte[] assignmentFile) {
		this.assignmentFile = assignmentFile;
	}

	public Student() {
		super();
	}
	
	

}
