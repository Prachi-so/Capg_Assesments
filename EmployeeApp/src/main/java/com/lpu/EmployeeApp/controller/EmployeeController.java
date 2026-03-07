package com.lpu.EmployeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingFilterBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.EmployeeApp.dto.EmployeeDTO;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	/*
	//using entity only
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee e){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEmployee(e));
	}
	*/
	
	//using dto
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEmployee(dto));
	}

}
