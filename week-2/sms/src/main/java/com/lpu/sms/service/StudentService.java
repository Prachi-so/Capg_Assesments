package com.lpu.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


import com.lpu.sms.entity.Student;
import com.lpu.sms.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	
//	public Optional<Student> findStudentById(int id) {
//		return repo.findById(id);
//	}
	
//	public List<Student> findAllStudents(){
//		return repo.findAll();
//	}
	
	public String deleteStudentById(int id) {
		repo.deleteById(id);
		return "deleted";
	}

	public List<Student> studentPaginationSorted(int pageNumber, int size, String field){
		Pageable  pageable=PageRequest.of(pageNumber, size, Sort.by(field).descending());
		return repo.findAll(pageable).getContent();  
	}
	
	//@PostAuthorize("returnObject.name==authentication.name")
	public Student findStudentbyId(int id) {
		return repo.findById(id).get();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<Student> findAllStudent(){
		return repo.findAll();
	}
}
