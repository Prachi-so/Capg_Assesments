package com.lpu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
