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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Regular3Test {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/provajderi-neformalne-edukacije";
    }

    @Test
    public void testSelectSarajevoCheckboxes() {
        driver.get(baseUrl);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[novalidate]")));


        WebElement sarajevoCheckbox = driver.findElement(By.id("1_Sarajevo"));

        sarajevoCheckbox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(sarajevoCheckbox.isSelected(), "Sarajevo checkbox is not selected.");

    }
    @Test
    public void testSelectBanjaLukaCheckboxes() {
        driver.get(baseUrl);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[novalidate]")));

        WebElement banjaLukaCheckbox = driver.findElement(By.id("2_Banja Luka"));

        banjaLukaCheckbox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        assertTrue(banjaLukaCheckbox.isSelected(), "Banja Luka checkbox is not selected.");

    }
    @Test
    public void testSelectTuzlaCheckboxes() {
        driver.get(baseUrl);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[novalidate]")));



        WebElement tuzlaCheckbox = driver.findElement(By.id("3_Tuzla"));

        tuzlaCheckbox.click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(tuzlaCheckbox.isSelected(), "Tuzla checkbox is not selected.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
