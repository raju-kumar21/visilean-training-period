package com.springboot.transactionmanagement.bootspringtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springboot.transactionmanagement.bootspringtransaction.domain.Assignment;
import com.springboot.transactionmanagement.bootspringtransaction.domain.User;
import com.springboot.transactionmanagement.bootspringtransaction.service.UserAssignmentService;

@SpringBootApplication
public class BootspringtransactionApplication {

	public static void main(String[] args) {
ApplicationContext ctx=		SpringApplication.run(BootspringtransactionApplication.class, args);
	System.out.println("Boot spring transaction Application running....");

		UserAssignmentService userAssignmentService=ctx.getBean(UserAssignmentService.class);

		User user=new User();

		user.setFirstName("Raju");
		user.setLastName(" Kumar");

		Assignment assignment=new Assignment();

		assignment.setAssignmentName("Java Training with MicroService...");

		assignment.setUserDetail(user);

		userAssignmentService.assignTrainingToUser(user, assignment);

	}

}
