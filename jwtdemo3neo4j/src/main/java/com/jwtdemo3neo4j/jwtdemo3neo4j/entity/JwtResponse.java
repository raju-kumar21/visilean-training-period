package com.jwtdemo3neo4j.jwtdemo3neo4j.entity;



public class JwtResponse {

    private String jwtToken;

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
    
}
