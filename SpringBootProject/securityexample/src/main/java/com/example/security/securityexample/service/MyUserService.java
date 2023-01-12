package com.example.security.securityexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.example.security.securityexample.entity.UserLog;

@Service
public class MyUserService {
    
    @Autowired
    UserDetailsManager userDetailsManager;

    @Autowired
    PasswordEncoder encoder;

    public void addUser(UserLog userLog)
    {
        userLog.setPassword(encoder.encode(userLog.getPassword()));
        userDetailsManager.createUser(userLog);
    }
}
