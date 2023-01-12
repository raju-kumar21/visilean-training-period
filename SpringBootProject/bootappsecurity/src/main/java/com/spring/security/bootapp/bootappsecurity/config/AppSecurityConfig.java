package com.spring.security.bootapp.bootappsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.spring.security.bootapp.bootappsecurity.authprovider.OTPAuthTokenProvider;
import com.spring.security.bootapp.bootappsecurity.authprovider.UserPasswordAuthProvider;
import com.spring.security.bootapp.bootappsecurity.filter.UserPasswordAuthFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Lazy
    @Autowired UserPasswordAuthFilter filter;

    @Autowired UserPasswordAuthProvider provider;

    @Autowired OTPAuthTokenProvider otpProvider;
      
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider)
        .authenticationProvider(otpProvider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.addFilterAt(filter, BasicAuthenticationFilter.class);
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    } 
 

}
