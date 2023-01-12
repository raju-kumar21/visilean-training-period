package com.springboot.transactionmanagement.bootspringtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.springboot.transactionmanagement.bootspringtransaction.domain.User;
import com.springboot.transactionmanagement.bootspringtransaction.repo.UserRepo;

@Service
public class UserService {

    @Lazy
    @Autowired
    UserRepo userRepo;

    public User saveUser(User user)
    {
        return userRepo.save(user);
    }

    
}
