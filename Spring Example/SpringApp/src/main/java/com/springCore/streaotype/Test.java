package com.springCore.streaotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("com/springCore/streaotype/config.xml");		
		
		Student obj=context.getBean("student",Student.class);
		
		System.out.println(obj);
		System.out.println(obj.getAddress());
		
	}

}
 