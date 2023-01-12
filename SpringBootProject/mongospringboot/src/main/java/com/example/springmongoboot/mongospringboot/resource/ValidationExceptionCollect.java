package com.example.springmongoboot.mongospringboot.resource;

public class ValidationExceptionCollect extends Exception {

    public ValidationExceptionCollect(String message) {
        super(message);
    }
    

    public static String NotFoundException(String id)
    {
        return "Book with Id :"+id+" Not Found...";
    }

    public static String BookAlreadyExits()
    {
        return "Book Already Exits...";
    }

}
