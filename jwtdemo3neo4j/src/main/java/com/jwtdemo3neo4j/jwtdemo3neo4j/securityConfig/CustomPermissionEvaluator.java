package com.jwtdemo3neo4j.jwtdemo3neo4j.securityConfig;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.JwtTokenData;
import com.jwtdemo3neo4j.jwtdemo3neo4j.repo.StudentRepo;

public class CustomPermissionEvaluator implements PermissionEvaluator {

	 	@Autowired
	    StudentRepo studentRepo;

	    @Autowired
	    JwtTokenData jwtTokenData;
	
	    @Autowired
	    Authentication authentication;
	
	
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		// TODO Auto-generated method stub
		authentication.getAuthorities();
		System.out.println("PermissionEvaluator in : "+authentication.getAuthorities());
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
