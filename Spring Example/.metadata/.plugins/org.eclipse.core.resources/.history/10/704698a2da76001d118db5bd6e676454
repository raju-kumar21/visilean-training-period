package com.springCore.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springCore/autowiring/autoConfig.xml");
		
		Emp obj=(Emp)context.getBean("Emp");
		
		
		System.out.println(obj);
		
	}

}
