package com.example2.security.example2security.configure;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig {
    @Bean
    public UserDetailsService userDetailsService()
    {
        var ud=new InMemoryUserDetailsManager();

        var user=org.springframework.security.core.userdetails.User
        .withUsername("root")
        .password("root").authorities("read").build();

        ud.createUser(user);

        return ud;
    }

    @Bean 
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
