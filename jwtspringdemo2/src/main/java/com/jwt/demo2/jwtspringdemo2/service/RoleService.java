package com.jwt.demo2.jwtspringdemo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.demo2.jwtspringdemo2.dao.RoleRepo;
import com.jwt.demo2.jwtspringdemo2.dao.UserRepo;
import com.jwt.demo2.jwtspringdemo2.entity.Role;

@Service
public class RoleService {
    

    @Autowired
    private RoleRepo roleRepo;

    

    public Role createNewRole(Role role)
    {
        return roleRepo.save(role);
    }
}
