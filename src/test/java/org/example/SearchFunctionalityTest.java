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

public class SearchFunctionalityTest {

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
    public void testSearchFunctionalityWithProgrammingKeyword() {
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-round.btn-white i.fas.fa-search")
        ));
        searchButton.click();

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Unesite pojam koji tražite...']")
        ));
        searchField.sendKeys("Kursevi");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-round.btn-default")
        ));
        submitButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testSearchFunctionalityWithSpecialCharacters() {
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-round.btn-white i.fas.fa-search")
        ));
        searchButton.click();

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Unesite pojam koji tražite...']")
        ));
        searchField.sendKeys("%%%%%");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-round.btn-default")
        ));
        submitButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
