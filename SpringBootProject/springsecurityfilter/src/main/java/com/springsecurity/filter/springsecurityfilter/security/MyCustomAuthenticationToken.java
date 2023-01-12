package com.springsecurity.filter.springsecurityfilter.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class MyCustomAuthenticationToken 
extends UsernamePasswordAuthenticationToken{

    public MyCustomAuthenticationToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public MyCustomAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
    
}
