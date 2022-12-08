package com.springcore.lifecycle;

public class BeanLifeCycle {
	 private String name;

	public BeanLifeCycle(String name) {

		this.name = name;
	}
	 
	public BeanLifeCycle() {
		
	}

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		System.out.println("setter method call");
		this.name = name;
	}
	 
	@Override
	public String toString() {
		return "BeanLifeCycle [name=" + name + "]";
	}
	
	public void init() {
		System.out.println("Inside init method");
	}
	
	public void destroy() {
		System.out.println("Inside destroy method");
	}
	
	
}
