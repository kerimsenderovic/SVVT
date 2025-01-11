package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Regular5Test {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/online-platforme";
    }

    @Test
    public void testCalendarNextButton() {
        driver.get(baseUrl);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.page-link.ng-star-inserted")));


        WebElement pageLink = driver.findElement(By.cssSelector("a.page-link.ng-star-inserted"));
        String initialUrl = driver.getCurrentUrl();


        pageLink.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));


        String expectedUrl = "https://itkarijera.ba/online-platforme?page=2&pageSize=9&sortOrder=asc&sortField=Name&filter=%7B%7D";
        String newUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, newUrl, "URL after clicking the page link does not match expected URL");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
