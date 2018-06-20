package com.vaibhavsood.web.application;

import com.vaibhavsood.business.service.ScreeningService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ScreeningController.class)
public class ScreeningControllerTest {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @MockBean
    private ScreeningService screeningService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getScreenings() throws Exception {
        this.mockMvc.perform(get("/screenings?date=2018-05-25")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("")));

    }
}
