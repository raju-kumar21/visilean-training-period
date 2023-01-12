package com.example.springmongoboot.mongospringboot.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class Book {

    @Id
    @NotNull(message = "Id cannot be null")
    private int id;

    @NotNull(message = "bookName cannot be null")
    private String bookName;

    @NotNull(message = "authorName cannot be null")
    private String authorName;

    
    public Book() {
    }

    public Book(int id, String bookName, String authorName) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + "]";
    }

    
    
}
