package com.lpu.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.sms.entity.Student;
import com.lpu.sms.repository.StudentRepository;




@Service
public class StudentUserDetailsService implements UserDetailsService{
	@Autowired
	private  StudentRepository repo;
	
	@Override								//username should be unique
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Student s=repo.findByName(username);
		return new StudentUserDetails(s);
		
	}
}

