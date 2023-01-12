package com.secure.springboot.securespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secure.springboot.securespringboot.entity.UserLog;
import com.secure.springboot.securespringboot.repo.LoginUser;
import com.secure.springboot.securespringboot.repo.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    // public class LoginUserDetailsService {

        
    @Autowired
    UserRepository userRepository;

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
   
    public LoginUserDetailsService() {
    }

    /**
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username)  {
        
        Optional<UserLog> userLog=userRepository.findByUsername(username);
        System.out.println("User Details :"+userLog);
        UserLog userLog1=userLog.orElseThrow(()-> new UsernameNotFoundException("User not Found..."));

        return new LoginUser(userLog1);
    }

    /**
     * @param userLog
     * @return
     */
    public UserLog addUserLog(UserLog userLog) {
        UserLog userLog1=this.userRepository.save(userLog);
        return userLog1;
    }

    public List<UserLog> getall() {
        List<UserLog> userLog1=(List)this.userRepository.findAll();
        return userLog1;
    }

    
}
