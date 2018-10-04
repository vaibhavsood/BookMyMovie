package com.vaibhavsood.data.repository;

import com.vaibhavsood.data.entity.Theatre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TheatreRepositoryIntegrationTest {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Before
    public void init() {
        Theatre aNewTheatre = new Theatre();
        aNewTheatre.setTheatreName("RAHUL");
        aNewTheatre.setTheatreCity("PUNE");

        testEntityManager.persist(aNewTheatre);
        testEntityManager.flush();
    }

    @Test
    public void testFindByTheatreId() {
        Theatre foundTheatre = theatreRepository.findByTheatreId(2L);

        assertNotNull(foundTheatre);
        assertEquals(foundTheatre.getTheatreName(), "INOX");
    }

    @Test
    public void testFindByTheatreNameAndTheatreCity() {
        Theatre foundTheatre = theatreRepository.findByTheatreNameAndTheatreCity("RAHUL", "PUNE");

        assertNotNull(foundTheatre);
        assertThat(foundTheatre.getTheatreName(), is(equalTo("RAHUL")));
    }
}