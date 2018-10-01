package com.vaibhavsood.business.service;

import com.vaibhavsood.business.domain.MovieScreening;
import com.vaibhavsood.data.entity.Screening;
import com.vaibhavsood.data.entity.Theatre;
import com.vaibhavsood.data.repository.ScreeningRepository;
import com.vaibhavsood.data.repository.TheatreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScreeningServiceUnitTest {
    @Mock
    private ScreeningRepository screeningRepository;

    @Mock
    private TheatreRepository theatreRepository;

    @InjectMocks
    private ScreeningService screeningService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBookSeats() {
        Theatre aMockTheatre = new Theatre();
        aMockTheatre.setTheatreName("INOX");
        aMockTheatre.setTheatreCity("PUNE");
        aMockTheatre.setTheatreId(2);

        when(theatreRepository.findByTheatreNameAndTheatreCity(anyString(), anyString())).thenReturn(aMockTheatre);

        Screening aMockScreening = new Screening();
        aMockScreening.setMovieName("Race 3");
        aMockScreening.setScreenId(2);
        aMockScreening.setScreeningDate(java.sql.Date.valueOf("2018-05-25"));
        aMockScreening.setScreeningTime(java.sql.Time.valueOf("18:00:00"));
        aMockScreening.setScreeningId(1);
        aMockScreening.setBookedTickets(0);

        when(screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime(any(String.class),
                any(Long.class), java.sql.Date.valueOf(any(String.class)), java.sql.Time.valueOf(any(String.class)))).thenReturn(aMockScreening);

        MovieScreening aMovieScreening = new MovieScreening();

        int actualBookedSeats = screeningService.bookSeats(aMovieScreening, 5);

        assertEquals(actualBookedSeats, 5);
    }

    @Test
    public void testGetBookedSeats() {
        MovieScreening aMovieScreening = new MovieScreening();

        assertEquals(5, screeningService.getBookedSeats(aMovieScreening));
    }

    @Test
    public void testGetTotalSeats() {
        MovieScreening aMovieScreening = new MovieScreening();

        assertEquals(100, screeningService.getTotalSeats(aMovieScreening));
    }

    @Test
    public void getMovieScreeningsByDate() {
    }
}