package com.jwtdemo3neo4j.jwtdemo3neo4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtdemo3neo4j.jwtdemo3neo4j.entity.User;
import com.jwtdemo3neo4j.jwtdemo3neo4j.service.UserService;

@RestController
// @CrossOrigin
public class UserContoller {

    @Autowired
    private UserService userService;

    // @PostConstruct
    // public void initRolesAndUser()
    // {
    // userService.initRolesAndUser();
    // }
    @PostMapping({ "/registerNewUser" })
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

}
