package com.example.movieservice.controller;

import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    public final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.findAll());
    }


    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


    @PostMapping("/movies")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/movies/isavailable/{id}")
    public ResponseEntity<Void> changeIsAvailable(@PathVariable Long id){
        movieService.changeIsAvailable(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/movies/rent/{id}")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id){
        movieService.rentMovie(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
