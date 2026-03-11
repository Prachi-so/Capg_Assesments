package com.lpu.security2.service;



import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.security2.entity.Customer;
import com.lpu.security2.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository repo;

	private final PasswordEncoder passwordEncoder;
	
	//constructor injection
	public CustomerService(CustomerRepository repo, PasswordEncoder passwordEncoder) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}


	public Customer register(Customer customer) {
		String encodedPass=passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPass);
		//passwordEncoder.matches(encodedPass, "123") -- compare, return true/false
		return repo.save(customer);
	}
	
	
	@PostAuthorize("returnObject.name==authentication.name")
	public Customer findCustomerbyId(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteCustomerbyId(int id) {
		repo.deleteById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<Customer> findAllCustomer(){
		return repo.findAll();
	}
	
	
	

}
