package com.lpu.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.demo.entity.FileData;
import com.lpu.demo.repository.FileDataRepository;

@RestController
@RequestMapping("/api")
public class FileDataController {
	@Autowired
	private FileDataRepository repository;

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		FileData f=new FileData();
	f.setFileName(file.getOriginalFilename());  //data
		f.setFieldType(file.getContentType());  //pdf
		f.setData(file.getBytes()); //binary
		
		FileData saved=repository.save(f); //save in db
		
		return "File saved in DB with ID : "+saved.getId();
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable Long id){
		FileData file = repository.findById(id)
						.orElseThrow(()-> new RuntimeException("file not found with id " +id ));
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						"inline;fileName=\"" +file.getFileName() )  //inline, attachement
				.header(HttpHeaders.CONTENT_TYPE, file.getFieldType())
				.body(file.getData());
	}
	
}
