package com.lpu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	Student findByName(String username);

}
