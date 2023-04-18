package com.jwtdemo3neo4j.jwtdemo3neo4j.customException;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInput) {
        return new ResponseEntity<String>("Input field is Empty , Please look it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Permission.class)
    public ResponseEntity<String> handlePermission(Permission permission) {
        return new ResponseEntity<String>("You do not have permission for delete this user",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElement) {
        return new ResponseEntity<String>("No Value is present in DB , Please change your request..",
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception noSuchElement) {
        return new ResponseEntity<String>("Exception Occer Please cheack It....",
                HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<Object>("Plese change http method Type", HttpStatus.NOT_FOUND);
    }
}
