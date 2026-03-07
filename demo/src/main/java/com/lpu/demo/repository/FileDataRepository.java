package com.lpu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.demo.entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Long>{

}
