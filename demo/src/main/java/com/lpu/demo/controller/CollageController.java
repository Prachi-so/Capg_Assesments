package com.lpu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Collage;
import com.lpu.demo.service.CollageService;

@RestController
public class CollageController {
	
	@Autowired
	private CollageService service;
	
	@PostMapping("/savecollage")
	public Collage save(@RequestBody Collage collage) {
		return service.saveCollage(collage);
		
	}

}
