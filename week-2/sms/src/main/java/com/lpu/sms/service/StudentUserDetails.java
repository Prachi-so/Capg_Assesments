package com.lpu.sms.service;


import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.lpu.sms.entity.Student;

public class StudentUserDetails  implements UserDetails{

	private Student student;  

	

	public StudentUserDetails(Student student) {
		super();
		this.student = student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(student.getRole()));
	}

	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return student.getName();
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

