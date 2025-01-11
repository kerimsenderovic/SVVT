package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomepageLoadingTimeTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba";
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testHomepageLoadingTime() {

        driver.get(baseUrl);


        long startTime = System.currentTimeMillis();
        driver.get(baseUrl);
        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;

        int maxLoadTime = 5000;
        assertTrue(loadTime <= maxLoadTime, "Homepage did not load within acceptable time");

        System.out.println("Test Passed: Homepage loaded within acceptable time.");
    }
}