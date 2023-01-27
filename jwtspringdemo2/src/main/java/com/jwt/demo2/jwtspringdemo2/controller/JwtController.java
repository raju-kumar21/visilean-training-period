package com.jwt.demo2.jwtspringdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.demo2.jwtspringdemo2.entity.JwtRequest;
import com.jwt.demo2.jwtspringdemo2.entity.JwtResponse;
import com.jwt.demo2.jwtspringdemo2.service.JwtService;

@RestController
@CrossOrigin
public class JwtController {
    
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception
    {
        return jwtService.createJwtToken(jwtRequest);
    }



}
