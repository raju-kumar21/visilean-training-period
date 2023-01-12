package com.springsecurity.filter.springsecurityfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/home")
    public String home()
    {
        return "filter home...???";
    }


}
