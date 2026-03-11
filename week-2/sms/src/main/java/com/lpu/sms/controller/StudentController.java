package com.lpu.sms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.lpu.sms.entity.Student;
import com.lpu.sms.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/addstudent")
	public String addStudent(@RequestBody Student  student) {
		 service.saveStudent(student);
		 return "data inserted";
	}
	
	@GetMapping("/fetchstudent/{id}")
	public Student fetchStudentById(@PathVariable int id) {
		return service.findStudentbyId(id);
	}
	

	
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudentById(id);
	}
	
	@GetMapping("/page/{pageNumber}/{size}/sortby/{field}")
	public List<Student> mobilePageSorted(@PathVariable int  pageNumber, @PathVariable int  size , @PathVariable String field){
		return service.studentPaginationSorted(pageNumber, size, field);
	}
	
	@PostMapping("/upload/{id}")
	public String uploadImage(@PathVariable int id,
	                          @RequestParam("file") MultipartFile file) throws IOException {

	    Student student = service.findStudentbyId(id);
	    		
	         //   .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

	    student.setProfile_image(file.getBytes());

	    service.saveStudent(student);

	    return "Image uploaded successfully for student ID: " + id;
	}
	
	/*
	@GetMapping("/download/profile/{id}")
	public ResponseEntity<byte[]> downloadProfile(@PathVariable int id) {

	    Student s = service.findStudentbyId(id)
	            .orElseThrow(() -> new RuntimeException("File not found with id " + id));

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                    "inline; filename=\"profile.jpg\"")
	            .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
	            .body(s.getProfile_image());
	}
	
	@GetMapping("/download/assignment/{id}")
	public ResponseEntity<byte[]> downloadAssignment(@PathVariable int id) {

	    Student s = service.findStudentbyId(id)
	            .orElseThrow(() -> new RuntimeException("File not found with id " + id));

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                    "attachment; filename=\"assignment.pdf\"")
	            .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
	            .body(s.getAssignmentFile());
	}
	*/
	
//	@GetMapping("/findall")
//	public List<Student> findAllStudents(){
//		return service.findAllStudent();
//	}
			
}
