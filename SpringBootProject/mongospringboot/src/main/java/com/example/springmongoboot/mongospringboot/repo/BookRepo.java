package com.example.springmongoboot.mongospringboot.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springmongoboot.mongospringboot.model.Book;

@Repository
public interface BookRepo extends MongoRepository<Book,Integer>{
    

    // @Query(value = "{'Books':?0}")
    Optional<Book> findByBookName(String bookName);



}
