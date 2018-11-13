package com.vaibhavsood.runner;

import com.vaibhavsood.data.repository.MovieRepository;
import com.vaibhavsood.data.repository.ScreeningRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DataLoaderIntegrationTest {
    @Autowired
    private DataLoader dataLoader;

    @Before
    public void setUp() throws Exception {
        try {
            dataLoader.run(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPopulateMovieTable() {
        MovieRepository movieRepository = dataLoader.getMovieRepository();

        assertNotNull(movieRepository.findByMovieName("Toy Story"));
        assertEquals(movieRepository.findByMovieName("Toy Story").getMovieName(), "Toy Story");
        assertEquals(movieRepository.findByMovieName("Toy Story").getMoviePosterUrl(),
                "https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_UX182_CR0,0,182,268_AL__QL50.jpg");
    }
}