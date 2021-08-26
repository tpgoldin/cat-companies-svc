package com.tpg.cat.companies.application;

import com.tpg.cat.companies.application.web.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@ActiveProfiles("int")
public class HomeAccessSIT {
    private WebDriver webDriver;

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/opt/WebDriver/bin/geckodriver");

        webDriver = new FirefoxDriver();

        homePage = new HomePage(webDriver);
    }

    @AfterEach
    public void tearDown() {
        webDriver.close();
    }

    @Test
    public void givenUserWantsToLookForTradesPerson_whenAccessingHome_thenHomePageIsDisplayed() {

        assertThat(homePage.getTradeCategorySelector()).isNotNull();
    }
}
