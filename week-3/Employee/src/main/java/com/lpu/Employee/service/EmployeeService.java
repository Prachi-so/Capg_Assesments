package com.lpu.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.lpu.Employee.entity.Employee;
import com.lpu.Employee.repository.EmployeeRepository;




@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	
	public List<Employee> findAllEmployee() {
		return repository.findAll();
	}
	
	public Employee findEmployeeById(int id) {
		Optional<Employee> optional=repository.findById(id);
		return optional.get();   
		
		
	}
	
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}
	
	public List<Employee> findByName(String name){
		return repository.findByName(name);
	}
	
	public List<Employee> findByDept(String dept){
		return repository.findByDept(dept);
	}
	
	public List<Employee> findByPhone(long phone){
		return repository.findByPhone(phone);
	}
	
	public List<Employee> findByEmail(String email){
		return repository.findByEmail(email);
	}
	
	 public List<Employee> getEmployeesBySalaryRange(Double minSalary, Double maxSalary) {
	        return repository.findBySalaryBetween(minSalary, maxSalary);
	    }
	 
//	 public Employee getEmployeesWithMaxSalary() {
//	        return repository.findEmployeeWithMaxSalary();
//	        		}

}
