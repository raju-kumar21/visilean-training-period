package com.springboot.jsp.jspwithspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.jsp.jspwithspringboot.mode.User;

@Service
public class ServiceLayer {

    /**
     *
     */
    
    private final RestTemplate restTemplate;

    @Autowired
    public ServiceLayer(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }


    public User consumeAPI()
    {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1",User.class);
    }

}
