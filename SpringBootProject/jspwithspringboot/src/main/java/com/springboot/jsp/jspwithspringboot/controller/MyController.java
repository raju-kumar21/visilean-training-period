package com.springboot.jsp.jspwithspringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.jsp.jspwithspringboot.mode.User;
import com.springboot.jsp.jspwithspringboot.mode.Users;
import com.springboot.jsp.jspwithspringboot.service.ServiceLayer;



// @Controller
@RequestMapping("/HOME")
@RestController
public class MyController {
    
    private Logger logger =LoggerFactory.getLogger(MyController.class);
    
    @Autowired
    private ObjectMapper objectMapper;
    
    private final ServiceLayer serviceLayer;

    @Autowired
    public MyController(ServiceLayer serviceLayer)
    {
        this.serviceLayer=serviceLayer;
    }
    // @RequestMapping("/home")
       @GetMapping("/home")
        public String home()
        {
            System.out.println("this is home page...");
            return "HOME/home/home.jsp";    
        }

        @PostMapping("/add")
        public ResponseEntity<?>addUser(@RequestParam("file")MultipartFile file,@RequestParam("userData")String userData)
        {

            this.logger.info("Add user request");
            
            this.logger.info("File Information :{}",file.getOriginalFilename());
           
            

            //convertion string to json
            Users users=null;

            try {
                users =objectMapper.readValue(userData,Users.class);
                this.logger.info("Users : {}",users);
            } catch (Exception e) {
               
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input invalied..");
            }
          
            return ResponseEntity.ok(users+file.getOriginalFilename());
        }


        @GetMapping("/API")
        public ResponseEntity<User> getData()
        {
            return new ResponseEntity(serviceLayer.consumeAPI(),HttpStatus.OK);
        }

}
