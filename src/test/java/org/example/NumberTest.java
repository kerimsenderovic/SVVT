package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTest {

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
    public void number1() {
        driver.get(baseUrl);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"paginator\"]/div/nav/ul/li[1]/a | //*[@id=\"paginator\"]/div/nav/ul/li[1]/a/span | //a[contains(@class, 'page-link')]")
        ));


        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();


        element.click();


        assertEquals("https://itkarijera.ba/studijski-programi?page=2&pageSize=10&sortOrder=asc&sortField=Department&filter=%7B%7D", driver.getCurrentUrl());
    }
    @Test
    public void number2() {
        driver.get("https://itkarijera.ba/studijski-programi?page=2&pageSize=10&sortOrder=asc&sortField=Department&filter=%7B%7D");

        // Wait for the element to be clickable using combined XPaths
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"paginator\"]/div/nav/ul/li[3]/a | //*[@id=\"paginator\"]/div/nav/ul/li[3]/a/span | //a[contains(@class, 'page-link')]")
        ));


        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();


        element.click();


        assertEquals("https://itkarijera.ba/studijski-programi?page=1&pageSize=10&sortOrder=asc&sortField=Department&filter=%7B%7D", driver.getCurrentUrl());
    }
    @Test
    public void number3() {
        driver.get("https://itkarijera.ba/studijski-programi?page=2&pageSize=10&sortOrder=asc&sortField=Department&filter=%7B%7D");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"paginator\"]/div/nav/ul/li[4]/a | //*[@id=\"paginator\"]/div/nav/ul/li[4]/a/span")
        ));


        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();


        element.click();


        assertEquals("https://itkarijera.ba/studijski-programi?page=4&pageSize=10&sortOrder=asc&sortField=Department&filter=%7B%7D", driver.getCurrentUrl());
    }
}
