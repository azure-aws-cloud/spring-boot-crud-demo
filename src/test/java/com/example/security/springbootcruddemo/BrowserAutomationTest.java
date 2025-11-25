package com.example.security.springbootcruddemo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAutomationTest {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver(); // opens Chrome browser
    }

    @Test
    void testSwaggerUiLoads() {
        driver.get("http://localhost:8080/swagger-ui/index.html");
        String title = driver.getTitle();

        Assertions.assertTrue(title.contains("Swagger"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

