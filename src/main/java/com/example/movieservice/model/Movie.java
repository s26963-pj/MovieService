package com.example.movieservice.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Movie ID", example = "1", nullable = false)
    private Long id;
    @Schema(name = "Name of the movie", example = "Hobbit", nullable = false)
    private String name;
    @Schema(name = "Category of the movie", example = "Horror", nullable = false)
    private String category;
    @Column(nullable = false)
    @Schema(name = "Is available in store", example = "True", nullable = false)
    private Boolean is_available;

    public Movie(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.is_available = false;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIs_available() {
        return is_available;
    }

    public void setIs_available(Boolean is_available) {
        this.is_available = is_available;
    }
}
