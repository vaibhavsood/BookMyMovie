package com.vaibhavsood;

import com.vaibhavsood.business.service.ScreeningServiceIntegrationTest;
import com.vaibhavsood.data.repository.ScreeningRepositoryIntegrationTest;
import com.vaibhavsood.web.application.ScreeningControllerIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ScreeningServiceIntegrationTest.class, ScreeningControllerIntegrationTest.class,
        ScreeningRepositoryIntegrationTest.class})
public class MovieScreeningTestSuite {
}
