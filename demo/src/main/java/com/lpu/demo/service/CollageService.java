package com.lpu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Collage;
import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.CollageRepository;

@Service
public class CollageService {
	@Autowired
	private CollageRepository repository;
	
	public Collage saveCollage(Collage collage) {   //same method can be used for update also
		return repository.save(collage);
	}
	/*
	public void assignStudentsToCollage(int Clgid, List<int> StuId) {
		Collage c=repository.findById(clgid);
		
	}
	*/

}
