package com.lpu.EmployeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.EmployeeApp.dto.EmployeeDTO;
import com.lpu.EmployeeApp.entity.Company;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.exceptions.CompanyNotFoundException;
import com.lpu.EmployeeApp.exceptions.EmployeeNotFoundException;
import com.lpu.EmployeeApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	/*
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	*/
	
	public Employee findEmployeeById(int id) {
		return repository.findById(id).orElseThrow(
				()-> new EmployeeNotFoundException("employee with id " + id +" does not exist")
				);
	}
	
	//using dto layer instead of entity
	public EmployeeDTO entityToDto(Employee emp) {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setAge(emp.getAge());
		dto.setName(emp.getName());
		dto.setPhone(emp.getPhone());
		return dto;
	}
	
	
	//controller->save(dto)->entity->save(repository)
	public Employee DtoToEntity(EmployeeDTO dto) {
		Employee e=new Employee();
		e.setAge(dto.getAge());
		e.setName(dto.getName());
		e.setPhone(dto.getPhone());
		return e;
	}
	
	public EmployeeDTO saveEmployee(EmployeeDTO dto) {
		Employee employee=DtoToEntity(dto);
		Employee e=repository.save(employee);
		return entityToDto(e);
	}
	
	

	
}
