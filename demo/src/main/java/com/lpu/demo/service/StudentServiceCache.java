package com.lpu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Student;
import com.lpu.demo.exceptions.ResourceNotFoundException;
import com.lpu.demo.repository.StudentRepository;

@Service
public class StudentServiceCache {
	@Autowired
	private StudentRepository repository;
	
	@Cacheable(value="students", key="#id")
	public Student getStudentById(int id) {
		System.err.println("Fetching from db----"); //just to check cache working
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("student not found"));
	}

	//#result.id-- means use the returned student object's id after saving
	//when adding(//updating student, update cache
	@CachePut(value="students", key="#result.id")
	public Student addStudent(Student newStudent) {
		return repository.save(newStudent);
	}
	
	// #Id->method parameter  (student id)
	//when we call getStudentById(10), cache key=10
	@CachePut(value="students",key="#id")
	public Student updateStudent(int id, Student student) {
		Student existing=getStudentById(id);
		existing.setName(student.getName());
		existing.setPhone(student.getPhone());
		return repository.save(existing);
	}
	
	//key="#id"-- key to store cache data , store in key value pair, value is cache name
	//remove cache when deleting
	@CacheEvict(value="students", key="#id")
	public void deleteStudent(int id) {
		repository.deleteById(id);
	}
	

}
