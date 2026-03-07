package com.lpu.EmployeeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.EmployeeApp.dto.CompanyDTO;
import com.lpu.EmployeeApp.dto.EmployeeDTO;
import com.lpu.EmployeeApp.entity.Company;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.exceptions.CompanyNotFoundException;
import com.lpu.EmployeeApp.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository repository;
	
	@Autowired
	private EmployeeService empService;
	
	public Company findCompanyById(int id) {
		return repository.findById(id).orElseThrow(
				()-> new CompanyNotFoundException("company with id " + id +" does not exist")
				);
	}
	
	//only saving the company
	public Company saveCompany(Company company) {
		return repository.save(company);
	}
	
	//saving company and mapping with employee, by this only relationship will build
	public Company saveCompanyAndMapWithEmp(Company company) {
		company.getEmployees().forEach((emp)->emp.setCompany(company));
		return repository.save(company);
	}
	
	public Company saveEmployeesToExistingCompany( int companyId, List<Employee> newEmp) {
		Company company =  repository.findById(companyId).orElse(null);
		
		company.getEmployees().addAll(newEmp);
		
		//return repository.save(company);
		return saveCompanyAndMapWithEmp(company);
	}
	

		

}

