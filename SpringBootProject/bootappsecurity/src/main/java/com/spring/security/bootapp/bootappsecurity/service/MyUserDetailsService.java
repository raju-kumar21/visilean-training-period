package com.spring.security.bootapp.bootappsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.security.bootapp.bootappsecurity.model.SecureUser;
import com.spring.security.bootapp.bootappsecurity.model.UserInfo;
import com.spring.security.bootapp.bootappsecurity.repo.UserDetailsRepo;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired UserDetailsRepo userDetailsRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserInfo userInfo= userDetailsRepo.findByUsername(username).orElse(new UserInfo());
        return new SecureUser(userInfo);
    }
    
}
