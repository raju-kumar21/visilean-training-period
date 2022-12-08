package com.springCore.standalone.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springCore/standalone/collection/aloneconfig.xml");
		
		Person obj=(Person)context.getBean("person");
		
		System.out.println(obj);
		
		

		Person obj2=(Person)context.getBean("person1");
		
		System.out.println(obj2);
		System.out.println(obj.getFriends().getClass().getName());
		System.out.println("_______________________________________________");
		System.out.println(obj.getFeestructure());
		System.out.println(obj.getFeestructure().getClass().getName());
	}

}
