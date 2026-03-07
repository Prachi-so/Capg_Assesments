package com.lpu.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;

@RestController  
public class MyController {
	//method- get
	//url-http://localhost:8080/hi
	@GetMapping("/hi")   //url+method type
	public String takeReq() {
		return "byeee";
		
	}
	
	//method- get
	//url- http://localhost:8080/takeData?id=101&name=prachi 
	@GetMapping("/takeData")
	public String takeData(@RequestParam int  id, @RequestParam String name) {
		return "ID="+id+" NAME= "+name;
	}
	
	
	//method- get
	//url-http://localhost:8080/collage?id=10&name=prachi&location=jalandhar
	@GetMapping("/collage")
	public String collage(@RequestParam int  id, @RequestParam String name, @RequestParam String location) {
		return "ID = "+id+" NAME = "+name+" LOCATION = "+location;
	}
	
	
	//url- http://localhost:8080/takeData2/108
	@GetMapping("/takeData2/{id}")
	public String takeData2(@PathVariable int id) {
		return "ID = "+id;
		
	}
	
	//url- http://localhost:8080/takeData3/108/prachi
	@GetMapping("/takeData3/{id}/{name}")
	public String takeData3(@PathVariable int id, @PathVariable String name) {
			return "ID = "+id+" NAME = "+name;
			
	}
	
	//url- http://localhost:8080/student/10/collage/cId=456
	@GetMapping("/student/{sId}/collage/{cId}")
	public String takeData4(@PathVariable int sId, @PathVariable int cId) {
		return "STUDENT ID = "+sId+" COLLAGE ID = "+cId;
		
	}
	
	//url- http://localhost:8080/student/10/collage?cId=98
		@GetMapping("/student/{sId}/collage")
		public String takeData5(@PathVariable int sId, @RequestParam int cId) {
			return "STUDENT ID = "+sId+" COLLAGE ID = "+cId;
			
		}
		
	//url-http://localhost:8080/takeData4
	//header, key=id, value=44
	//header, key=name, value=prachi
	@GetMapping("/takeData4")
	public String takeData6(@RequestHeader int id, @RequestHeader String name) {
		return "ID = "+id +" NAME = "+name;
	}
	
	//url-http://localhost:8080/student
	@GetMapping("/student")
	public String getStudent(@RequestBody Student  s) {
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getPhone());
		return s.getName()+" is received.";  
		
	}

	//url-http://localhost:8080/student2
	@GetMapping("/student2")
	public Student getStudent2(@RequestBody Student  s) {

		return s;  //returning json object only
		
	}
	
}
