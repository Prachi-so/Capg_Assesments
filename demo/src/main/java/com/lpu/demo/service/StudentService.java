package com.lpu.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.StudentRepository;

@Service
public class StudentService {
	//business logic
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student) {   //same method can be used for update also
		return repository.save(student);
	}
	
	public Student findStudentById(int id) {
		Optional<Student> optional=repository.findById(id);
		return optional.get();   //Optional act like a null pointer exception
		
		//return repository.findById(id).orElse(null); //we can also use it 
	}
	
	public void deleteStudent(Student student) {
		repository.delete(student);
		//repository.deleteById(id); this will take id
	}
	
	public List<Student> findAllStudent() {
		return repository.findAll();
	}
	
	public void deleteStudentById(int id) {
		repository.deleteById(id);
	}
	
	public  List<Student> saveAllStudents(List<Student> list){
		return repository.saveAll(list);
	}
	
	//**********CUSTOM METHODS STARTS ************
	public List<Student> findByName(String name){
		return repository.findByName(name);
	}
	
	public Student findByNameAndPhone(String name, long phone) {
		return repository.findByNameAndPhone(name, phone);
	}
	//**********CUSTOM METHODS ENDS ************
	
	//**********CUSTOM QUERY STARTS ************
	
	public List<Student> getStudentByName(String n){
		return repository.findByName(n);
	}
	
	
	public List<Student> getAllStudent(){
		return repository.getAllStudent();
	}
	
	//**********CUSTOM QUERY ENDS ************
	
	
//	public StudentService() {
//	}
//
//	public StudentService(StudentRepository repository) {
//		this.repository = repository;
//	}

}
