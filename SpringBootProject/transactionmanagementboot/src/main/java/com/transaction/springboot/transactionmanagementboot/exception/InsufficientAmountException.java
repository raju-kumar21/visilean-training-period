package com.transaction.springboot.transactionmanagementboot.exception;

public class InsufficientAmountException extends RuntimeException {

    public InsufficientAmountException( String msg)
    {
        super(msg);
    }
    
}
