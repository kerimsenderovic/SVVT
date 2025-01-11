package org.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HTTPTest {

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
    public void testHttpRedirectionToHttps() {

        driver.get("http://itkarijera.ba");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.getCurrentUrl().startsWith("https://itkarijera.ba"));


        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.startsWith("https://itkarijera.ba"), "URL should be using HTTPS");
    }
    @Test
    public void testSecureCookies() {

        driver.get("https://itkarijera.ba");


        Set<Cookie> cookies = driver.manage().getCookies();


        boolean secureCookieFound = false;
        for (org.openqa.selenium.Cookie cookie : cookies) {
            if (cookie.isSecure()) {
                secureCookieFound = true;
                break;
            }
        }


        assertTrue(secureCookieFound, "A secure cookie should be set.");
    }
} 