package com.springCore.streaotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("Raju")
	private String studentName;
	
	@Value("Saharsa")
	private String city;

	@Value("#{stu}")
	private List<String> address;
	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Student(String studentName, String city) {
		super();
		this.studentName = studentName;
		this.city = city;
	}
	
	public Student() {
		
	}

	 
	
	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", city=" + city + "]";
	}
	
	
	
	
	
}
