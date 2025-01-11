package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileResponsivenessTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 14_7_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1");

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
    public void testMobileResponsiveness() {
        driver.get(baseUrl);


        driver.manage().window().setSize(new Dimension(518, 848));

        Dimension expectedSize = new Dimension(518, 848);
        Dimension actualSize = driver.manage().window().getSize();
        assertEquals(expectedSize, actualSize, "The page is not rendered in iPhone 12 Pro resolution");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement startButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Kako i gdje početi?')]")));
        assertTrue(startButton.isDisplayed(), "The 'Kako i gdje početi?' button is not displayed.");

        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("header")));
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));

        assertTrue(header.isDisplayed(), "Header is not displayed correctly.");
        assertTrue(footer.isDisplayed(), "Footer is not displayed correctly.");

        System.out.println("Test Passed: Page is responsive on mobile devices.");
    }

    @Test
    public void testTabletResponsiveness() {
        driver.get(baseUrl);


        driver.manage().window().setSize(new Dimension(1024, 1366));

        Dimension expectedSize = new Dimension(1024, 1366);
        Dimension actualSize = driver.manage().window().getSize();
        assertEquals(expectedSize, actualSize, "The page is not rendered in iPad Pro (12.9-inch) resolution");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement navMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar")));
        assertTrue(navMenu.isDisplayed(), "The navigation menu is not displayed correctly on tablet resolution.");

        WebElement callToAction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Saznaj više')]")));
        assertTrue(callToAction.isDisplayed(), "The 'Saznaj više' button is not displayed on tablet resolution.");

        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("header")));
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));

        assertTrue(header.isDisplayed(), "Header is not displayed correctly.");
        assertTrue(footer.isDisplayed(), "Footer is not displayed correctly.");

        System.out.println("Test Passed: Page is responsive on iPad Pro (12.9-inch).");
    }
    @Test
    public void testMobileResponsivenessAndroid() {
        driver.get(baseUrl);

        driver.manage().window().setSize(new Dimension(412, 732));

        Dimension expectedSize = new Dimension(412, 732);
        Dimension actualSize = driver.manage().window().getSize();
        assertEquals(expectedSize, actualSize, "The page is not rendered in Pixel 3 XL resolution");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement startButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Kako i gdje početi?')]")));
        assertTrue(startButton.isDisplayed(), "The 'Kako i gdje početi?' button is not displayed.");

        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("header")));
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));

        assertTrue(header.isDisplayed(), "Header is not displayed correctly.");
        assertTrue(footer.isDisplayed(), "Footer is not displayed correctly.");

        System.out.println("Test Passed: Page is responsive on Android device (Pixel 3 XL).");
    }
}
