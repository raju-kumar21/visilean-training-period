package com.spring.security.bootapp.bootappsecurity.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.security.bootapp.bootappsecurity.model.UserSecretKey;

public interface UserSecretKeyRepo extends CrudRepository<UserSecretKey,Integer> {

Optional<UserSecretKey>    findByUsername(String uname);
    
}
