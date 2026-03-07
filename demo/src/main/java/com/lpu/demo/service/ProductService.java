package com.lpu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Product;
import com.lpu.demo.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repository;

	@Autowired  // using constructor injection instead of field, @autowired not mandatory here since one constructor
	public ProductService(ProductRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Product> saveAllProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	public List<Product> productPagination(int pageNumber, int size){
		Pageable  pageable=PageRequest.of(pageNumber, size);
		return repository.findAll(pageable).getContent();  //getContent to convert page to list
	}
	
	//field- id/name/price
	public List<Product> sortProductByFielddDesc(String field){ 
		return repository.findAll(Sort.by(field).descending());
	}
	
	public List<Product> sortProductByFielddAsce(String field1, String field2){ 
		return repository.findAll(Sort.by(field1,field2).ascending());
	}
	
	//pagination in sorted order
	public List<Product> productPaginationSorted(int pageNumber, int size, String field){
		Pageable  pageable=PageRequest.of(pageNumber, size, Sort.by(field).descending());
		return repository.findAll(pageable).getContent();  //getContent to convert page to list
	}
}
