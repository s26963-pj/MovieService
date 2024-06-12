package com.example.movieservice.exeptions;

public class MovieNoExceptionFoundException extends RuntimeException {
    public MovieNoExceptionFoundException(String message) {
        super(message);
    }
}
