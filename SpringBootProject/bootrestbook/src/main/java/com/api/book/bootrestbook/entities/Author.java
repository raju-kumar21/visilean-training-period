package com.api.book.bootrestbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
@XmlRootElement
public class Author {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int authorId;

    private String firstName;

    private String lastName;

    private String langusge;

    /**
     *
     */
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;
    

   

    public Author() {
    }

    

    public Author(int authorId, String firstName, String lastName, String langusge,Book book) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.langusge = langusge;
        this.book = book;

    }



    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLangusge() {
        return langusge;
    }

    public void setLangusge(String langusge) {
        this.langusge = langusge;
    }



    public Book getBook() {
        return book;
    }



    public void setBook(Book book) {
        this.book = book;
    }

    

    


}
