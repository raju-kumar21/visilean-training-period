package com.spring.security.bootapp.bootappsecurity.repo;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.spring.security.bootapp.bootappsecurity.model.UserInfo;

public interface UserDetailsRepo extends CrudRepository<UserInfo , Integer> {
    
    Optional<UserInfo> findByUsername(String uname);
}
