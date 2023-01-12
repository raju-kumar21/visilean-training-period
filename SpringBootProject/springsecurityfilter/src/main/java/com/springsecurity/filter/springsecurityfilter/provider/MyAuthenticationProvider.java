package com.springsecurity.filter.springsecurityfilter.provider;

import javax.security.auth.message.config.AuthConfigProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springsecurity.filter.springsecurityfilter.security.MyCustomAuthenticationToken;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Value("${secret_key}")
    String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      if(secretKey.equals(authentication.getName()))
      {
        return new MyCustomAuthenticationToken(null,null,null);
      }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
      
        return MyCustomAuthenticationToken.class.equals(authentication);
    }
    
}
