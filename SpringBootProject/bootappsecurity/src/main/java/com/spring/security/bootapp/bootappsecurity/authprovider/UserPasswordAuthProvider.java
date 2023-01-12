package com.spring.security.bootapp.bootappsecurity.authprovider;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.security.bootapp.bootappsecurity.auth.UserPasswordAuthToken;
import com.spring.security.bootapp.bootappsecurity.service.MyUserDetailsService;

@Component
public class UserPasswordAuthProvider implements AuthenticationProvider {
  
    @Autowired MyUserDetailsService userDetailsService;
    @Lazy
    @Autowired PasswordEncoder encoder;

    



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var user = userDetailsService.
        loadUserByUsername(authentication.getName());

        if(encoder.matches(authentication.getCredentials()+"", user.getPassword()))
        {
        return new UserPasswordAuthToken(user.getUsername(),
        user.getPassword());
        }

        throw new BadCredentialsException("Failed User Authentication ??");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UserPasswordAuthToken.class.equals(authentication);
    }
    
}
