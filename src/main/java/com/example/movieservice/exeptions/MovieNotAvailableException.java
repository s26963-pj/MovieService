package com.example.movieservice.exeptions;

public class MovieNotAvailableException extends RuntimeException{
    public MovieNotAvailableException(String message) {
        super(message);
    }
}
