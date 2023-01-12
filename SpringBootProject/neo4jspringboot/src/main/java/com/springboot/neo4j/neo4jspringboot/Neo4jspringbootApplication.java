package com.springboot.neo4j.neo4jspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Neo4jspringbootApplication {
	

	public static void main(String[] args) {
	SpringApplication.run(Neo4jspringbootApplication.class, args);
		System.out.println("Neo4j Started....");
		// BookController ob=(BookController) ctx.getBean("book");
		
	}

}
