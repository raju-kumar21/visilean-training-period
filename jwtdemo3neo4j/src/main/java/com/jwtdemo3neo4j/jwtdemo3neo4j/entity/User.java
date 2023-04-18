package com.jwtdemo3neo4j.jwtdemo3neo4j.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;



@Node
public class User {

    @Id
    private String userName;

    private String userPassword;

    private String role;

    
    
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userPassword, String role) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    

}
