package com.springboot.neo4j.neo4jspringboot.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.springboot.neo4j.neo4jspringboot.controller.BookController;
import com.springboot.neo4j.neo4jspringboot.repo.BookRepo;

@Configuration

@ComponentScan(basePackages = "com.springboot")
public class MyConfig {
    /**
     *
     */
    BookRepo bookRepo;

    /**
     * @return
     */
   
    //  @Bean(name="bookcontroller")
    @Lazy
    public BookController book()
    {
       
        return new BookController(bookRepo);
    }
}
