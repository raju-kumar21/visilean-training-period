package com.example.security.securityexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.securityexample.entity.UserLog;
import com.example.security.securityexample.service.MyUserService;

@RestController
public class HomeController {
    
    @Autowired
    MyUserService service;

    @GetMapping("/index")
    public String home()
    {
        return "Spring Security....";
    }



    @PostMapping("/index")
    public void createUser(@RequestBody UserLog userLog)
    {
        System.out.println("post hittt..");
        service.addUser(userLog);
    }
}
