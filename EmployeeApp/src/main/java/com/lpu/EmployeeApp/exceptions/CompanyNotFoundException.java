package com.lpu.EmployeeApp.exceptions;

public class CompanyNotFoundException extends RuntimeException{

	public CompanyNotFoundException(String message) {
		super(message);
	}
}
