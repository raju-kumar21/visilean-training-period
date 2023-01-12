package com.springsecurity.filter.springsecurityfilter.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyBasicCustomAuthenticationFilter implements Filter{


    AuthenticationManager manager;

    
    @Lazy
    @Autowired
    public MyBasicCustomAuthenticationFilter(AuthenticationManager manager) {
        this.manager = manager;
    }




    @Override
    public void doFilter(ServletRequest request, 
    ServletResponse response, 
    FilterChain chain)
            throws IOException, ServletException {
        //based upon request
        HttpServletRequest userRequest=(HttpServletRequest)request;
        String authObj=userRequest.getHeader("auth_key");

        //create authentication object...
            var objTocken= new MyCustomAuthenticationToken( authObj,null);

        //delegate obj to AuthenticationManager ---> AuthenticationProvider
        try {
            var authPrincipal=manager.authenticate(objTocken);
            

            //for future use save principal into SecurityContext.....
            if(authPrincipal.isAuthenticated())
            {
                SecurityContextHolder.getContext().setAuthentication(authPrincipal);
                chain.doFilter(request, response);
            }
        } catch (AuthenticationException e) {
                new BadCredentialsException("Invalid Principal....");
        }
    
    
    }
    
}
