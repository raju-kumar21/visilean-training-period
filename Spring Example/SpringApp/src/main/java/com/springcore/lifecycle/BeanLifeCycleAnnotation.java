 package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifeCycleAnnotation {
	
	private String name;

	public BeanLifeCycleAnnotation(String name) {
		
		this.name = name;
	}
	
	public BeanLifeCycleAnnotation() {}

	public String getName() {
		
		System.out.println("getter method of Annotation");
		return name;
	}

	public void setName(String name) {
		
		System.out.println("Setter method of Annotaion....");
		this.name = name;
	}

	@Override
	public String toString() {
		return "BeanLifeCycleAnnotation [name=" + name + "]";
	}
	
	
	
	@PostConstruct
	public void init()
	{
		System.out.println("Init method of Annotation....");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("Destroy method of Annotation...");
	}
	
	
}
