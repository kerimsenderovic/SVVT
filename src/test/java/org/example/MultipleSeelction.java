package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleSeelction {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/studijski-programi";
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void selection() {
        driver.get(baseUrl);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1_Sarajevo")));
        element.click();


        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("4_4 godine")));
        element1.click();


        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("0_I ciklus")));
        element2.click();

        String expectedUrl = "https://itkarijera.ba/studijski-programi?page=1&pageSize=10&sortOrder=asc&sortField=Department&filter=%7B%22cityIds%22:%5B1%5D,%22durations%22:%5B4%5D,%22studyCycles%22:%5B0%5D,%22tagIds%22:%5B%5D%7D";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void selection1() {
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("3_Tuzla")));
        element.click();

        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("5_5 godina")));
        element1.click();

        String expectedUrl = "https://itkarijera.ba/studijski-programi?page=1&pageSize=10&sortOrder=asc&sortField=Department&filter=%7B%22cityIds%22:%5B3%5D,%22durations%22:%5B5%5D,%22studyCycles%22:%5B%5D,%22tagIds%22:%5B%5D%7D";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
