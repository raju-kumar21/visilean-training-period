package com.spring.security.bootapp.bootappsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/home")
    @PreAuthorize("hasRole('write')")
    public String home()
    {
        return "Hi 2 Step Authentication... ??";
    }


}
