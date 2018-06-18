package com.vaibhavsood.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @Column(name = "MOVIE_NAME")
    private String movie_name;
    @Column(name = "MOVIE_LANGUAGE")
    private String movie_language;
    @Column(name = "MOVIE_LENGTH")
    private int movie_length;

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_language() {
        return movie_language;
    }

    public void setMovie_language(String movie_language) {
        this.movie_language = movie_language;
    }

    public int getMovie_length() {
        return movie_length;
    }

    public void setMovie_length(int movie_length) {
        this.movie_length = movie_length;
    }
}
