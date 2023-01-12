package com.spring.security.bootapp.bootappsecurity.authprovider;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.spring.security.bootapp.bootappsecurity.auth.OTPAuthToken;
import com.spring.security.bootapp.bootappsecurity.repo.UserSecretKeyRepo;

@Component
public class OTPAuthTokenProvider implements AuthenticationProvider {

    @Autowired UserSecretKeyRepo secretKeyRepo;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        var user=secretKeyRepo.findByUsername(authentication.getName());

        if(user.isPresent())
        {
            return new OTPAuthToken(authentication.getName(),
            authentication.getCredentials(),Arrays.asList(()->"read")
            );
        }

       throw new BadCredentialsException("Failed Secret-key Authentication ??");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OTPAuthToken.class.equals(authentication);
    }
    
}
