package com.lpu.security2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.security2.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	//custom method
	Customer findByName(String name); //returning one customer coz name is unique
}
