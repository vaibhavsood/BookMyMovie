package com.vaibhavsood.business.service;

import com.vaibhavsood.business.domain.MovieScreening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScreeningServiceIntegrationTest {

    @Autowired
    ScreeningService screeningService;

    @Test
    public void testBookSeats() {
        MovieScreening aMovieScreening = new MovieScreening();
        aMovieScreening.setMovieName("Race 3");
        aMovieScreening.setScreeningDate("2018-05-25");
        aMovieScreening.setScreeningTime("18:00:00");
        aMovieScreening.setTheatreCity("PUNE");
        aMovieScreening.setTheatreName("INOX");
        aMovieScreening.setNumSeats(5);

        int expectedBookedSeats = screeningService.getBookedSeats(aMovieScreening)+5;

        int actualBookedSeats = screeningService.bookSeats(aMovieScreening, expectedBookedSeats);

        assertEquals(actualBookedSeats, expectedBookedSeats);
    }

    @Test
    public void testGetBookedSeats() {
        MovieScreening aMovieScreening = new MovieScreening();
        aMovieScreening.setMovieName("Race 3");
        aMovieScreening.setScreeningDate("2018-05-25");
        aMovieScreening.setScreeningTime("18:00:00");
        aMovieScreening.setTheatreCity("PUNE");
        aMovieScreening.setTheatreName("INOX");

        assertEquals(5, screeningService.getBookedSeats(aMovieScreening));
    }

    @Test
    public void testGetTotalSeats() {
        MovieScreening aMovieScreening = new MovieScreening();
        aMovieScreening.setMovieName("Race 3");
        aMovieScreening.setScreeningDate("2018-05-25");
        aMovieScreening.setScreeningTime("18:00:00");
        aMovieScreening.setTheatreCity("PUNE");
        aMovieScreening.setTheatreName("INOX");

        assertEquals(100, screeningService.getTotalSeats(aMovieScreening));
    }

    @Test
    public void getMovieScreeningsByDate() {
    }
}