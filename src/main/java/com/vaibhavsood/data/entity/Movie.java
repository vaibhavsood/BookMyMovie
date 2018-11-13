package com.vaibhavsood.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "MOVIE_ID")
    private String movieId;
    @Column(name = "MOVIE_POSTER_URL")
    private String moviePosterUrl;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMoviePosterUrl() {
        return moviePosterUrl;
    }

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }
}
