package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/springcore/lifecycle/beanlife.xml");
		
//		BeanLifeCycle obj=(BeanLifeCycle)context.getBean("B1");
		
//		System.out.println(obj);
	
		
//		System.out.println("\nUsing Interface........\n");
//		BeanLifeCycleInterface obj2=(BeanLifeCycleInterface)context.getBean("B2");
//		System.out.println(obj2);
//		
		
		
		System.out.println("\n");
//		System.out.println(obj.getName());

		
		BeanLifeCycleAnnotation obj3=(BeanLifeCycleAnnotation)context.getBean("B3");
		
		System.out.println(obj3);
		
		
		
		
		
		
		
		
		
		context.registerShutdownHook();
		System.out.println("context info : "+context.containsBean("B3"));
	}

}
