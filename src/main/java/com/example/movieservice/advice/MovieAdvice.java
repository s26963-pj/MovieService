package com.example.movieservice.advice;

import com.example.movieservice.exeptions.MovieNotFoundException;
import com.example.movieservice.exeptions.MovieWrongDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestControllerAdvice
public class MovieAdvice extends RuntimeException {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured on request.Exception message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(MovieWrongDataException.class)
    public ResponseEntity<String> handleMovieWrongDataException(MovieWrongDataException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured on request.Exception message: " + ex.getLocalizedMessage());
    }

}
