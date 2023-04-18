package demofortesting.demofortesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemofortestingApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	 applicationContext=SpringApplication.run(DemofortestingApplication.class, args);
		
	Object bean =applicationContext.getBean("myProp");
	String myProp=(String)bean;

	System.out.println("My Bean : "+myProp);
	
	
	System.out.println(" for Testing App is running....");
	}

}
