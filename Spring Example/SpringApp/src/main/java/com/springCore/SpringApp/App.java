package com.springCore.SpringApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	
    	Student obj=(Student)context.getBean("student1");
    	Student obj2=(Student)context.getBean("student2");
    	
        System.out.println( obj);
        System.out.println( obj2);
        
        
        
        
        
    }
}
