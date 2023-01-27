package com.jwt.demo2.jwtspringdemo2.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.demo2.jwtspringdemo2.entity.Role;

@Repository
public interface RoleRepo extends MongoRepository<Role,String> {
    
}
