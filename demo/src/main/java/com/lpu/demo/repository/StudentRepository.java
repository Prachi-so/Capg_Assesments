package com.lpu.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	//custom method
	List<Student> findByName(String name);
	
	Student findByNameAndPhone(String name, long phone);
	
	//custom query
	@Query("select s from Student s where s.name=:n")
	List<Student> getStudentByName(String n);
	
	@Query(nativeQuery=true, value="select * from Student")
	List<Student> getAllStudent();
}
