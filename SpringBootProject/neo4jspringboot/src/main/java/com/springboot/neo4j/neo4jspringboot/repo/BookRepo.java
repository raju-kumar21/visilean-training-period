package com.springboot.neo4j.neo4jspringboot.repo;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.springboot.neo4j.neo4jspringboot.nodemodel.Book;

public interface BookRepo extends Neo4jRepository<Book,Integer> {

    List<Book> findByName(String name);
    
}
