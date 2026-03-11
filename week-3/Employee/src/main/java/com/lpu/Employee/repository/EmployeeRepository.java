package com.lpu.Employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.Employee.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

	List<Employee> findByName(String name);
	List<Employee> findByDept(String dept);
	List<Employee> findByPhone(long phone);
	List<Employee> findByEmail(String email);
	
	List<Employee> findBySalaryBetween(double minSalary, double maxSalary);
	
	/*
	@Query(nativeQuery=true, value= "SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)")
	Employee findEmployeeWithMaxSalary();
	*/
}
