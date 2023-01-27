package com.jwt.demo2.jwtspringdemo2.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.demo2.jwtspringdemo2.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    
}
