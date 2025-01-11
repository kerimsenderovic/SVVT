package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    public void testLoadingTime() {
        driver.get(baseUrl);

        WebElement kakoPocetiButton = driver.findElement(By.cssSelector("a.btn.btn-red.text-light[href='/html-page/90/it-karijera-kako-i-gdje-poceti']"));

        long startTime = System.currentTimeMillis();

        kakoPocetiButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.urlContains("/html-page/90/it-karijera-kako-i-gdje-poceti")
        );


        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;

        int maxLoadTime = 5000;
        assertTrue(loadTime <= maxLoadTime, "Page did not load within acceptable time");

        System.out.println("Test Passed: Navigation to 'Kako i gdje početi?' took " + loadTime + " milliseconds.");

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://itkarijera.ba/html-page/90/it-karijera-kako-i-gdje-poceti";
        expectedUrl = expectedUrl.replaceAll("/+$", "");  // Remove any trailing slashes for comparison

        assertEquals(expectedUrl, currentUrl, "Navigation failed for 'Kako i gdje početi?' link");
        System.out.println("Test Passed: Navigation to 'Kako i gdje početi?' works correctly!");
    }



}