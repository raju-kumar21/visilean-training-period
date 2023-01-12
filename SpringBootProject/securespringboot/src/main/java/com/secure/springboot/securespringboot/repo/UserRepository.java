package com.secure.springboot.securespringboot.repo;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.secure.springboot.securespringboot.entity.UserLog;

@Repository
public interface UserRepository extends CrudRepository<UserLog,Integer> {


    Optional<UserLog> findByUsername(String username);
    
}
