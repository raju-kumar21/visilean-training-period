package com.example.springmongoboot.mongospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongospringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongospringbootApplication.class, args);
		System.out.println("Mongo running.....");
	
	
	}


}
