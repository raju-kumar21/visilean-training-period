package com.secure.springboot.securespringboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.secure.springboot.securespringboot.service.LoginUserDetailsService;



@Configuration
public class MysecurityConfig {
    
    @Bean
    public UserDetailsService userDetailsService()
    {
       
        return new LoginUserDetailsService();
    }

    @Bean 
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
