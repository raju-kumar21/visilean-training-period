package com.secure.springboot.securespringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.secure.springboot.securespringboot.repo.UserRepository;
import com.secure.springboot.securespringboot.service.LoginUserDetailsService;

@SpringBootApplication
public class SecurespringbootApplication {
	@Autowired
	static
	LoginUserDetailsService log;

	public static void main(String[] args) {
	
		SpringApplication.run(SecurespringbootApplication.class, args);
		
		
		System.out.println("Secure Spring boot running....");
		 

	}

}
