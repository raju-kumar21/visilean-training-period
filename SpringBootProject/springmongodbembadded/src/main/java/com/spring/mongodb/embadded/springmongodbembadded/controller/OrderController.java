package com.spring.mongodb.embadded.springmongodbembadded.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.embadded.springmongodbembadded.model.User;
import com.spring.mongodb.embadded.springmongodbembadded.repo.FlipkartRepo;

@RestController
public class OrderController {

        @Autowired
        private FlipkartRepo flipkartRepo;


        /**
         * @return
         */
        @PostMapping("/placeOrder")
        public String placeOrder(@RequestBody User user)
        {
            flipkartRepo.save(user);
            return "Order placed successfully...";
        }

        @GetMapping("/getUserByName/{name}")
        public List<User> getUserByName(@PathVariable String name)
        {
            return flipkartRepo.findByName(name);
        }

        @GetMapping("/getUserByAddress/{city}")
        public List<User> getUserByAddress(@PathVariable String city)
        {
            return flipkartRepo.findByCity(city);
        }


        @GetMapping("/getUserByProduct/{name}")
        public List<User> getUserByProduct(@PathVariable String name)
        {
            return flipkartRepo.findByProductName(name);
        }

}
