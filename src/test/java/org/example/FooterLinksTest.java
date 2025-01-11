package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooterLinksTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/";
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFooterLinks() {
        driver.get(baseUrl);


        WebElement footerLink = driver.findElement(By.xpath("//a[@routerlink='/prakse']"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footerLink);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(footerLink));

        js.executeScript("arguments[0].click();", footerLink);

        wait.until(ExpectedConditions.urlToBe("https://itkarijera.ba/prakse"));

        assertEquals("https://itkarijera.ba/prakse", driver.getCurrentUrl());
    }

    @Test
    public void testFooterLinks2() {
        driver.get(baseUrl);

        WebElement footerLink = driver.findElement(By.xpath("//a[@routerlink='/poslovi']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footerLink);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(footerLink));

        js.executeScript("arguments[0].click();", footerLink);

        wait.until(ExpectedConditions.urlToBe("https://itkarijera.ba/poslovi"));

        assertEquals("https://itkarijera.ba/poslovi", driver.getCurrentUrl());
    }
}
