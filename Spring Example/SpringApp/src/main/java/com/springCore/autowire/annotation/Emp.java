package com.springCore.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {
	
	
		@Autowired
	    @Qualifier("ad")
		private Address add;

		
		  public Emp(Address add) {
			super();
			System.out.println("Inside the constructor");
			this.add = add;
		}
		
		public Emp() {
			
		}

		public Address getAdd() {
			return add;
		}

		@Autowired
		@Qualifier("ad1 ")
		public void setAdd(Address add) {
			System.out.println("Setter method call...");
			this.add = add;
		}

		@Override
		public String toString() {
			return "Emp [add=" + add + "]";
		}
		
		
		
}
