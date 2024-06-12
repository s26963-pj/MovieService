package com.example.movieservice.advice;

import com.example.movieservice.exeptions.MovieNoExceptionFoundException;
import com.example.movieservice.exeptions.MovieNotAvailableException;
import com.example.movieservice.exeptions.MovieNotFoundException;
import com.example.movieservice.exeptions.MovieWrongDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieAdvice extends RuntimeException {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured on request.Exception message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(MovieWrongDataException.class)
    public ResponseEntity<String> handleMovieWrongDataException(MovieWrongDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured on request.Exception message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(MovieNotAvailableException.class)
    public ResponseEntity<String> handleMovieNotAvailableException(MovieNotAvailableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured on request.Exception message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(MovieNoExceptionFoundException.class)
    public ResponseEntity<String> handle500Exception() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Exception occured on request. Invalid endpoint");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}
