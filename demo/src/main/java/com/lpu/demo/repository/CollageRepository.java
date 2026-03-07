package com.lpu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.demo.entity.Collage;



@Repository
public interface CollageRepository extends JpaRepository<Collage, Integer>{

}
