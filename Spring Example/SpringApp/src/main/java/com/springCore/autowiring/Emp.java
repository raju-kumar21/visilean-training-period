package com.springCore.autowiring;

public class Emp {
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

		public void setAdd(Address add) {
			this.add = add;
		}

		@Override
		public String toString() {
			return "Emp [add=" + add + "]";
		}
		
		
		
}
