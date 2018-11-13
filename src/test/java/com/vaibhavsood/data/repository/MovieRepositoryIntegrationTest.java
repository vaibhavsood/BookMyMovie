package com.vaibhavsood.data.repository;

import com.vaibhavsood.data.entity.Movie;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryIntegrationTest {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TestEntityManager testEntityManager;

    /*
    @Test
    @Ignore
    public void findByMovieName() {
        Movie aNewMovie = new Movie();
        aNewMovie.setMovieName("Pataakha");
        aNewMovie.setMovieLanguage("Hindi");
        aNewMovie.setMovieLength(180);

        testEntityManager.persist(aNewMovie);
        testEntityManager.flush();

        Movie foundMovie = movieRepository.findByMovieName("Pataakha");

        assertNotNull(foundMovie);
        assertEquals(foundMovie.getMovieName(), aNewMovie.getMovieName());
    }*/
}