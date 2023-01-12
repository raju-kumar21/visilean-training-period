package com.security.springboot.springbootsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.springboot.springbootsecurity.mode.User;

@Service
public class UserService {
    

    List<User> list=new ArrayList<>();

    public UserService()
    {
        list.add(new User("Raju","1234","raju@gmail.com"));
   
        list.add(new User("Rahul","5678","rahul@gmail.com"));

        list.add(new User("Rakesh","9123","rakesh@gmail.com"));

   
    }




    //getAll users
    public List<User> getAllUser()
    {
        return this.list;
    }

    //get single user

    public User getUser(String userName)
    {
        return this.list.stream().filter((user)->user.getUsername().equals(userName)).findAny().orElse(null);
    }

    //Add new user

    public User addUser(User user)
    {
        this.list.add(user);

        return user;
    }
}
