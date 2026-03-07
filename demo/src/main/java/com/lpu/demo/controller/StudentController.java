package com.lpu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;
import com.lpu.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/studentsave")
	public Student save(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@GetMapping("studentnew/{id}")
	public Student fetchStudentById(@PathVariable int id) {
		return service.findStudentById(id);
	}
	
	@DeleteMapping("/studentnew")
	public String deleteStudent(@RequestBody Student student) {
		service.deleteStudent(student);
		return "student deleted";
	}
	
	@GetMapping("/studentnew")
	public List<Student> findAllStudent(){
		return service.findAllStudent();
	}
	
	//delete by id
	@DeleteMapping("/student")
	public void deleteStudentById(@RequestParam int id) {
		 service.deleteStudentById(id);
	}
	
	@PostMapping("/student")
	public List<Student> saveAllStudent(@RequestBody List<Student> students){
		return service.saveAllStudents(students);
	}
	
	// ********* CUSTOME METHODS STARTS *********

	@PostMapping("/student/name/{name}")
	public List<Student> findStudentByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@PostMapping("/student/{name}/{phone}")
	public Student findStudentByNameAndPhone(@PathVariable String name, @PathVariable long phone) {
		return service.findByNameAndPhone(name, phone);
	}
	
	//**********CUSTOM METHODS ENDS ************
	
	//**********CUSTOM QUERY STARTS ************
	
	@PostMapping("/student/{name}")
	public List<Student> findStudentByNameQuery(@PathVariable String name){
		return service.getStudentByName(name);
	}
	
	@PostMapping("/studentAll")
	public List<Student> getAllStudents(){
		return service.getAllStudent();
	}
	
	//**********CUSTOM QUERY ENDS ************
}
