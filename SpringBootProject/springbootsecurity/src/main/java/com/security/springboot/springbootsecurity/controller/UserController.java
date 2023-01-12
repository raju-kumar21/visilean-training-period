package com.security.springboot.springbootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.springboot.springbootsecurity.mode.User;
import com.security.springboot.springbootsecurity.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    //All users
    @GetMapping("/alluser")
    public List<User>getAllUser()
    {
        return this.userService.getAllUser();
    }


    //return single user
    @GetMapping("/auser/{userName}")
    public User getUser(@PathVariable("userName") String userName)
    {
        return this.userService.getUser(userName);
    }

    //Add User
    @PostMapping("/add")
    public User add(@RequestBody User user)
    {
        return this.userService.addUser(user);
    }

}
