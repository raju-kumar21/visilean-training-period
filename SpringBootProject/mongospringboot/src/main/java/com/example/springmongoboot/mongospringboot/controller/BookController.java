package com.example.springmongoboot.mongospringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmongoboot.mongospringboot.model.Book;
import com.example.springmongoboot.mongospringboot.repo.BookRepo;


@RestController
public class BookController {
    
    MongoTemplate bookRepo;

    @Autowired
    BookRepo bookRepo2;

    

    @Autowired
    public BookController(MongoTemplate bookRepo) {
        this.bookRepo = bookRepo;
    }

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book)
    {
        bookRepo.save(book);
        return "Added Book with ID :"+book.getId();
    }

    @GetMapping("/FindAllBooks")
    public List<Book> getAllBooks()
    {
        return bookRepo.findAll(Book.class);
    }

    @GetMapping("/findBookById/{id}")
    public Book getBook(@PathVariable Integer id)
    {
        return bookRepo.findById(id,Book.class);
    }

    @GetMapping("/bookByName/{name}")
    public Optional<Book> getBookByName(@PathVariable String name)
    {
        return bookRepo2.findByBookName(name);
    }
    /**
     * @param id
     * @return
     */
    @DeleteMapping("/deleteBookById/{id}")
    public String deleteBook(@PathVariable Integer id)
    {
        bookRepo2.deleteById(id);
        return "Delete Book By Id :"+id;
    }

}
