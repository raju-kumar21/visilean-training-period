package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(1,"Java Complete Refrence JAVA","XYZ"));
    //     list.add(new Book(2,"Head First to Java","ABC"));
    //     list.add(new Book(3,"PYTHON ","CDEF"));

    // }

        @Autowired
        private BookRepository bookRepository;


    //get all books

    public List<Book> getAllBooks()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    //get single book by id

    public Book getBookById(int id)
    {
        Book book=null;
        try {
            
            //   book= list.stream().filter(e->e.getId()==id).findFirst().get();
            book=this.bookRepository.findById(id);
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
       return book;
    }


    //adding the book
    public Book addBook(Book b)
    {
    //    list.add(b);
        Book book=this.bookRepository.save(b);
        return book;
    }

    //delete book

    public void deleteBook(int bookId) {
        
        // list= list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());

        this.bookRepository.deleteById(bookId);

    }

    //update book

    public void updateBook(Book book,int bookId)
    {
        // list =list.stream().map(b->{
        //     if(b.getId()==bookId)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;

        // }).collect(Collectors.toList());

            book.setId(bookId);
            this.bookRepository.save(book);


    }

    

}
