package com.jwtdemo3neo4j.jwtdemo3neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication

//@ComponentScan(basePackages ="")

public class Jwtdemo3neo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jwtdemo3neo4jApplication.class, args);

		System.out.println("Jwtdemo 3 using neo4j running..");

	}

}
