package com.jpa.crud.jpacrudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



import com.jpa.crud.jpacrudapp.DAO.UserRepository;
import com.jpa.crud.jpacrudapp.Entity.User;

@SpringBootApplication
public class JpacrudappApplication {

	private static UserRepository userRepository;

	public static void main(String[] args) {
	ApplicationContext ctx=	SpringApplication.run(JpacrudappApplication.class, args);
	
	System.out.println("JPA CRUD APP Started..");
	
	userRepository = ctx.getBean(UserRepository.class);

	User user=new User();
		
	user.setName("Rahul");
	user.setCity("Patna");
	user.setStatus("I am developer..");
	
	User save= (User)userRepository.save(user);

	System.out.println(save);

}

}

