package com.springCore.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/autowire/annotation/autoConfig.xml");
		
		Emp obj=(Emp)context.getBean("Emp");
		
		
		System.out.println(obj);
		
	}

}
