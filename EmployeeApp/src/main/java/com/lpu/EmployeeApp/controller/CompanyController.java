package com.lpu.EmployeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.entity.Company;
import com.lpu.EmployeeApp.service.CompanyService;



@RestController
public class CompanyController {
	@Autowired
	private CompanyService service;
	
	
	@GetMapping("/company/{id}")
	public Company findCompanyById(@PathVariable int id) {
		return service.findCompanyById(id);
	}
	
	/*
	@PostMapping("/company")
	public Company saveCompany(@RequestBody Company company) {
		return service.saveCompany(company);
		
	}
	
	@PostMapping("/company2")
	public Company saveCompanyAWithMapping(@RequestBody Company company) {
		return service.saveCompanyAndMapWithEmp(company);
	}

	@PostMapping("/company/{cId}")
	public Company saveCompanyAWithMapping(@PathVariable int cId, @RequestBody List<Employee> employees) {
		return service.saveEmployeesToExistingCompany(cId, employees);
	}
	
	*/
	
	@GetMapping("/divide/{n1}/{n2}")
	public String divide(@PathVariable int n1, @PathVariable int n2) {
		return "result = "+ n1/n2;
	}
	
	
	//*********USING RESPONSE ENTITY**********
	@PostMapping("/company/new/")
	public ResponseEntity<Company> saveCompany2(@RequestBody Company  company) {
		Company body=service.saveCompany(company);
		return  ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	@PostMapping("/company2/2")
	public ResponseEntity<Company> saveCompanyAWithMapping2(@RequestBody Company company) {
		Company body=service.saveCompany(company);
		return new ResponseEntity<Company>(body,HttpStatus.CREATED);
	}
	
	@PostMapping("/company/new/{cId}")
	public ResponseEntity<Company> saveCompanyAWithMapping2(@PathVariable int cId, @RequestBody List<Employee> employees) {
		return null;
	}
}
