package com.lpu.EmployeeApp.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//************FOR COMPANY*************
//	@ExceptionHandler(ArithmeticException.class)
//	public Map<String, String> handleArithematicEx(ArithmeticException ex){
//		Map<String, String> map=new HashMap<String, String>();
//		map.put("Error", ex.getMessage());
//		return map;
//	}
	
	//status code change- 500 internal server error
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, String>> handleArithematicEx2(ArithmeticException ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
	
	/*
	@ExceptionHandler(CompanyNotFoundException.class)
	public Map<String, String> handleCompanyNotFoundException(CompanyNotFoundException ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return map;
	}
	*/
	
	
	//404 not found
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleCompanyNotFoundException(CompanyNotFoundException ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentException(MethodArgumentNotValidException ex){
		Map<String, String> map=new HashMap<>();
		ex.getBindingResult().getFieldErrors()
			.forEach(errors->map.put(errors.getField(), errors.getDefaultMessage()));
		return map;
	}
	*/
	
	//400 bad request
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentException(MethodArgumentNotValidException ex){
		Map<String, String> map=new HashMap<>();
		ex.getBindingResult().getFieldErrors()
			.forEach(errors->map.put(errors.getField(), errors.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	
	//it will handle all other exceptions which is not mentioned above
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleAllException(Exception ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return map;
	}
	
	
	//*********FOR EMPLOYEE***********
	
	//404 not found
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
