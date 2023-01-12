package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.dao.Books;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {
    
@Autowired
private BookService bookService;


@PostMapping("/addBook")
public ResponseEntity<Book> addbook(@RequestBody Book book)
{
    Book book1=null;

    try {
        book1=this.bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

}

// @GetMapping(value="/books",produces = {"application/json","application/xml","application/text"})
/**
 * @return
 */
// @GetMapping(value="/books",produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 
@GetMapping("/books")
public ResponseEntity<List<Book>> getBooks()
{
    List<Book>list=bookService.getAllBooks();
    if(list.size()<=0)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.of(Optional.of(list));
}

@GetMapping("/book/{id}")
public ResponseEntity<Book> getBookById(@PathVariable int id)
{
    Book book= bookService.getBookById(id);
    if(book==null)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(book));
}


//delete book
@DeleteMapping("/deleteBook/{bookId}")
public ResponseEntity<Void> deleBook(@PathVariable("bookId") int bookId)
{
    try {
        this.bookService.deleteBook(bookId);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

     

}

//update

@PutMapping("/books/{bookId}")
public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
{
    try {
        this.bookService.updateBook(book, bookId);
        return ResponseEntity.ok().body(book);

    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

// // @GetMapping(value="/bookxml",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
// // @GetMapping(value="/bookxml",produces = {"application/json","application/xml","application/text"})

// public ResponseEntity<List<Book>> getBooksXML()
// {
//     Books book=new Books();
//     List<Book>list=book.getBookXML();
//     if(list.size()<=0)
//     {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//     }

//     return ResponseEntity.of(Optional.of(list));
// }



}
