package com.springsecurity.filter.springsecurityfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@ComponentScan(basePackages = "com.springsecurity.filter.springsecurityfilter")
public class SpringsecurityfilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityfilterApplication.class, args);
		System.out.println("Filter is running..");
	}

}
