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

public class SidebarFilterTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/poslovi";
    }

    @Test
    public void testSelectSarajevoInCityDropdown() {
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ng-select[formcontrolname='cityIds']")));

        WebElement cityDropdown = driver.findElement(By.cssSelector("ng-select[formcontrolname='cityIds']"));
        cityDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ng-dropdown-panel-items")));
        WebElement sarajevoOption = driver.findElement(By.xpath("//span[contains(text(),'Sarajevo')]"));
        sarajevoOption.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement selectedCity = cityDropdown.findElement(By.cssSelector("div.ng-value"));
        assertTrue(selectedCity.getText().contains("Sarajevo"), "Sarajevo was not successfully selected.");
    }

    @Test
    public void testSelectMostarInCityDropdown() {
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ng-select[formcontrolname='cityIds']")));

        WebElement cityDropdown = driver.findElement(By.cssSelector("ng-select[formcontrolname='cityIds']"));
        cityDropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ng-dropdown-panel-items")));


        WebElement mostarOption = driver.findElement(By.xpath("//span[contains(text(),'Mostar')]"));
        mostarOption.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement selectedCity = cityDropdown.findElement(By.cssSelector("div.ng-value"));
        assertTrue(selectedCity.getText().contains("Mostar"), "Mostar was not successfully selected.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
