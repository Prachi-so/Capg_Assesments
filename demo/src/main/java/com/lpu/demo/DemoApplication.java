package com.lpu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;


//starting point of spring boot
@EnableCaching
@SpringBootApplication  //@configuration+@componentScan+@enableAutoConfiguration
public class DemoApplication {  //project name+Application

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.err.println("hiiiii");
	}
	
	
	//for cache
//	@Bean
//	public CacheManager cacheManager() {
//		return new ConcurrentMapCacheManager("students");
//	}
	

}
