package com.springboot.neo4j.neo4jspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.neo4j.neo4jspringboot.nodemodel.Book;
import com.springboot.neo4j.neo4jspringboot.repo.BookRepo;

@RestController
// @Component
public class BookController {


   

    public BookController() {
    }


    private BookRepo bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book)
    {
        bookRepo.save(book);
        return "Book Added...";
    }

    @GetMapping("/getBooks")
    public List<Book> getBook()
    {
        return bookRepo.findAll();
    }

    @GetMapping("/getBookByName/{name}")
    public List<Book> getBookByName(@PathVariable String name)
    {
        return bookRepo.findByName(name);
    }


    @DeleteMapping("/deleteBookById/{id}")
    public String getBookByName(@PathVariable Integer id)
    {
       bookRepo.deleteById(id);

       return "Book Deleted With "+id+" this ID";
    }

}
