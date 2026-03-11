package com.lpu.security2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.security2.entity.Customer;
import com.lpu.security2.repository.CustomerRepository;
import com.lpu.security2.service.CustomerUserDetails;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
	@Autowired
	private  CustomerRepository repo;
	
	@Override								//username should be unique
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Customer customer=repo.findByName(username);
		return new CustomerUserDetails(customer);
		
	}
}
