package com.lpu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;
import com.lpu.demo.service.StudentServiceCache;

@RestController
public class StudentControllerCache {
	@Autowired
	private StudentServiceCache service;
	
	@PostMapping("/stu")
	public Student saveStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@GetMapping("/student/{id}")
	public Student updateStudents(@PathVariable int id,  @RequestBody Student student) {
		return service.updateStudent(id, student);
	}
	
	@GetMapping("/stu/{id}")
	public Student fetchStudent(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	

}
