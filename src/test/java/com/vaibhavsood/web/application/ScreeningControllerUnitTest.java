package com.vaibhavsood.web.application;

import com.vaibhavsood.business.domain.MovieScreening;
import com.vaibhavsood.business.service.ScreeningService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ScreeningController.class)
public class ScreeningControllerUnitTest {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @MockBean
    private ScreeningService screeningService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Ignore
    public void getScreenings() throws Exception {
        this.mockMvc.perform(get("/screenings?date=2018-05-25")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("")));

    }

    @Test
    public void testBookSeats() throws Exception {
        MovieScreening aMovieScreening = new MovieScreening();
        aMovieScreening.setMovieName("Pataakha");
        aMovieScreening.setScreeningDate("2018-09-27");
        aMovieScreening.setScreeningTime("21:00:00");
        aMovieScreening.setTheatreCity("Pune");
        aMovieScreening.setTheatreName("Inox");
        aMovieScreening.setNumSeats(500);

        this.mockMvc.perform(post("/screenings", aMovieScreening)).andExpect(status().isOk())
        .andExpect(view().name("result"));
    }
}
