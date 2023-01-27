package com.jwt.demo2.jwtspringdemo2.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.demo2.jwtspringdemo2.entity.User;
import com.jwt.demo2.jwtspringdemo2.service.UserService;

@RestController
public class UserContoller {
    
    @Autowired private UserService userService;


    // @PostConstruct
    // public void initRolesAndUser()
    // {
    //     userService.initRolesAndUser();
    // }



    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user)
    {
        return  userService.registerNewUser(user);
    }


    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin()
    {
        return "This URL is only accessible to admin..";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser()
    {
        return "This URL is only accessible to User..";
    }



}
