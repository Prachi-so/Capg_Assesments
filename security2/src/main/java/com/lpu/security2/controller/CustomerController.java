package com.lpu.security2.controller;


import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.security2.entity.Customer;
import com.lpu.security2.service.CustomerService;

//@CrossOrigin-- any can use backended if enable this
//@CrossOrigin(origins="http://localhost:3000")  //frontend with this url can communicate
@RestController
public class CustomerController {

	private final CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return service.register(customer);
	}
	
	@GetMapping("/public")
	public String homePage() {
		return "public page";
	}
	
	@GetMapping("/csrf")
	public CsrfToken csrf(CsrfToken token) {
		return token;
	}
	
	@PostMapping("/save")
	public String save() {
		return "saved";
	}
	
	@GetMapping("/account")
	public String accountPage() {
		return "account page";
	}
	
	@GetMapping("/update")
	public String updatePage() {
		return "update page";
	}
	
	@GetMapping("/delete")
	public String deletePage() {
		return "delete page";
	}
	
	
	
	@GetMapping("/findAll")
	public String findAllPage() {
		return "find all page";
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteCustomerbyId(id);
		return "deleted";
	}
	
	@GetMapping("/findById/{id}")
	public Customer findById(@PathVariable int id) {
		return service.findCustomerbyId(id);
	}
}
