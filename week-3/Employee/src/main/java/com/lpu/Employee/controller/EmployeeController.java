package com.lpu.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.Employee.entity.Employee;
import com.lpu.Employee.service.EmployeeService;


@RequestMapping("/api")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}
	
	@GetMapping("/allemployee")
	public List<Employee> findAllEmployee(){
		return service.findAllEmployee();
	}
	
	@GetMapping("empid/{id}")
	public Employee fetchEmpById(@PathVariable int id) {
		return service.findEmployeeById(id);
	}
	
	@DeleteMapping("/deleteemp")
	public void deleteEmployeeById(@RequestParam int id) {
		 service.deleteEmployeeById(id);
	}
	
	@GetMapping("/empname/{name}")
	public List<Employee> findEmployeeByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping("/empdept/{dept}")
	public List<Employee> findEmployeeByDept(@PathVariable String dept){
		return service.findByDept(dept);
	}
	
	@GetMapping("/empphone/{phone}")
	public List<Employee> findEmployeeByPhone(@PathVariable long phone){
		return service.findByPhone(phone);
	}
	
	@GetMapping("/empemail/{email}")
	public List<Employee> findEmployeeByEmail(@PathVariable String email){
		return service.findByEmail(email);
	}
	
	 @GetMapping("/employees/search/{minSalary}/{maxSalary}")
	  public List<Employee> getEmployeesBySalaryRange(@PathVariable Double minSalary, @PathVariable Double maxSalary) {

	        return service.getEmployeesBySalaryRange(minSalary, maxSalary);
	    }
	 
//	 @GetMapping("employees/maxsalary")
//	    public Employee getEmployeesWithMaxSalary() {
//	        return service.getEmployeesWithMaxSalary();
//	    }

}
