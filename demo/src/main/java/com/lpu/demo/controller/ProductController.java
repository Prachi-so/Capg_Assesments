package com.lpu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Product;
import com.lpu.demo.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/saveAll")
	public List<Product> saveAllPro(@RequestBody List<Product> list){
		return service.saveAllProducts(list);
	}
	
	@GetMapping("/page/{pageNumber}/{size}")
	public List<Product> productPage(@PathVariable int  pageNumber, @PathVariable int  size){
		return service.productPagination(pageNumber, size);
	}
	
	
	//pages in sorted order by field
	//url-http://localhost:8081/product/page/0/3/sortby/name
	@GetMapping("/page/{pageNumber}/{size}/sortby/{field}")
	public List<Product> productPageSorted(@PathVariable int  pageNumber, @PathVariable int  size , @PathVariable String field){
		return service.productPaginationSorted(pageNumber, size, field);
	}
	
	//url-http://localhost:8081/product/sortby/price
	@GetMapping("/sortby/{field}")
	public List<Product> sortProductDesc(@PathVariable String field){
		return service.sortProductByFielddDesc(field);
	}
	
	//url-http://localhost:8081/product/sortby/name/price
	@GetMapping("/sortby/{field1}/{field2}")
	public List<Product> sortProductAsce(@PathVariable String field1, @PathVariable String field2){
		return service.sortProductByFielddAsce(field1, field2);
	}
}
