package com.shivani.packages.generics.exceptionHandling;

//every exception class inherits Exception class
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
