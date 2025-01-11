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

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationBarTest {

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
    public void testNavigateToITSektor() {
        driver.get(baseUrl);


        WebElement itSektorLink = driver.findElement(By.linkText("IT sektor"));
        itSektorLink.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdownContent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='tabletNavBar']/div/nav/div/ul/li[2]/div")
        ));


        assertTrue(dropdownContent.isDisplayed(), "Dropdown content for IT sektor is not displayed.");

        System.out.println("Test Passed: IT sektor dropdown displayed.");
    }

    @Test
    public void testNavigateToNovosti() {
        driver.get(baseUrl);


        WebElement itSektorLink = driver.findElement(By.linkText("IT sektor"));
        itSektorLink.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement novostiLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='tabletNavBar']/div/nav/div/ul/li[2]/div/span[1]/a")
        ));
        novostiLink.click();


        String expectedUrl = "https://itkarijera.ba/vijesti";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl, "Failed to navigate to /vijesti after clicking Novosti.");

        System.out.println("Test Passed: Navigated to Novosti (/vijesti).");
    }
}
