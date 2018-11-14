package com.vaibhavsood.data.repository;

import com.vaibhavsood.data.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    Movie findByMovieName(String movieName);
    Movie findByMovieId(long movieId);
}
