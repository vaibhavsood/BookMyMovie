package com.vaibhavsood.data.repository;

import com.vaibhavsood.data.entity.Theatre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends CrudRepository<Theatre, Long> {
    Theatre findByTheatreId(Long theatreId);
    Theatre findByTheatreNameAndTheatreCity(String theatreName, String theatreCity);
}
