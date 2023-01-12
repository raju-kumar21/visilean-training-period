package com.secure.springboot.securespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secure.springboot.securespringboot.entity.UserLog;
import com.secure.springboot.securespringboot.service.LoginUserDetailsService;

@RestController
public class HomeController {

    @Autowired
    LoginUserDetailsService login;

    @GetMapping("/home")
    public String home()
    {
        return "Home Security....";
    }
    
// @PostMapping("/addUserLog")
// public ResponseEntity<UserLog> addUser(@RequestBody UserLog userLog)
// {
//     try {
//         this.login.addUserLog(userLog);
//         return ResponseEntity.status(HttpStatus.CREATED).build();

//     } catch (Exception e) {
//         e.printStackTrace();
//     }
//     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

// }
}
