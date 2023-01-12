package com.example2.security.example2security.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class MyCustomAuthProvider implements AuthenticationProvider{

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        //athenticate to authentication user request...
        //throws AuthenticationException....
        //return null

        //user input getCredentials
        String password =authentication.getCredentials().toString();
        
        
        //fatch data from InMemeory db...

        var user=userDetailsService.loadUserByUsername(authentication.getName());

        if(user!=null && passwordEncoder.matches(password, user.getPassword()) )
        {
          return  new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString());
        }

        return (Authentication) new BadCredentialsException("Error...!!!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

    public MyCustomAuthProvider() {
    }
    



}
