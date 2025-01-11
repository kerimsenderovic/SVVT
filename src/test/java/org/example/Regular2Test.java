package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import static org.junit.jupiter.api.Assertions.assertTrue;

public class Regular2Test {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/html-page/80/informacije-i-savjeti-za-roditelje";
    }

    @Test
    public void testTextLocation() {
        driver.get(baseUrl);


        WebElement parentElement = driver.findElement(By.xpath("/html/body/app-root/app-pages-home/main/app-html-page-view/div/div[2]/div[2]/div[4]/div"));


        WebElement elementBelow = parentElement.findElement(By.xpath(".//div[2]"));


        assertTrue(elementBelow.isDisplayed(), "The element located below the specific parent element is not displayed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

