package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class LpuController {
	@RequestMapping("/m1")//used to handle all type of methods(post, get,...) request
	public String m1() {
		return "m1 method";
	}
	@PostMapping("/student")
	public String saveStudent() {
		return "student saved";
	}
	@PostMapping("/trainer")
	public String saveTrainer() {
		return "trainer saved";
	}
	@PostMapping("/security")
	public String saveSecurity() {
		return "security saved";
	}

}
