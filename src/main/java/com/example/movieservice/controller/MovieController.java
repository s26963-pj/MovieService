package com.example.movieservice.controller;

import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get all of the movies", description = "Return all movies")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.findAll());
    }


    @GetMapping("/movies/{id}")
    @Operation(summary = "Get movie by id", description = "Return one movie")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


    @PostMapping("/movies")
    @Operation(summary = "Adds a new movie", description = "Adds movie to database")
    @ApiResponse(responseCode = "200", description = "Successfully added")
    @ApiResponse(responseCode = "400", description = "Wrong data inserted", content = @Content)
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    @Operation(summary = "Updates movie", description = "Updates attributes of the movie")
    @ApiResponse(responseCode = "200", description = "Successfully updated")
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<Void> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/movies/{id}")
    @Operation(summary = "Deletes movie", description = "Deletes movie from database")
    @ApiResponse(responseCode = "204", description = "No content - deleted successfully", content = @Content)
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/movies/isavailable/{id}")
    @Operation(summary = "Changes isAvailable", description = "Changes the isAvailable attribute to true")
    @ApiResponse(responseCode = "200", description = "Successfully updated status")
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<Void> changeIsAvailable(@PathVariable Long id){
        movieService.changeIsAvailable(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/movies/rent/{id}")
    @Operation(summary = "Rent", description = "Rent the movie")
    @ApiResponse(responseCode = "200", description = "Successfully rented")
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @ApiResponse(responseCode = "400", description = "Movie with that id is not available", content = @Content)
    public ResponseEntity<Void> rentMovie(@PathVariable Long id){
        movieService.rentMovie(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
