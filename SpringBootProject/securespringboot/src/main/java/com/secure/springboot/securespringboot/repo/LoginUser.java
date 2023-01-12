package com.secure.springboot.securespringboot.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.secure.springboot.securespringboot.entity.UserLog;


public class LoginUser implements UserDetails {

    private final UserLog userLog;

  
    public LoginUser(UserLog userLog){
        this.userLog=userLog;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->"read");
    }

    @Override
    public String getPassword() {
        return userLog.getPassword();
    }

    @Override
    public String getUsername() {
        return userLog.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
