package com.vaibhavsood.business.service;

import com.vaibhavsood.business.domain.MovieScreening;
import com.vaibhavsood.data.repository.ScreeningRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScreeningServiceUnitTest {
    @Mock
    private ScreeningRepository screeningRepository;

    @InjectMocks
    private ScreeningService screeningService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

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