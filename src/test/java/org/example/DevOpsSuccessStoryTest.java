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

public class DevOpsSuccessStoryTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/uspjesne-price";
    }

    @Test
    public void testNavigateToDevOpsStory() {
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement storyLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/uspjesne-price/144/kako-je-adis-postao-devops-inzenjer']")
        ));
        storyLink.click();


        wait.until(ExpectedConditions.urlToBe("https://itkarijera.ba/uspjesne-price/144/kako-je-adis-postao-devops-inzenjer"));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://itkarijera.ba/uspjesne-price/144/kako-je-adis-postao-devops-inzenjer";
        assertTrue(actualUrl.equals(expectedUrl), "Failed to navigate to the DevOps success story page.");
    }

    @Test
    public void testTwitterSharingLink() {
        driver.get("https://itkarijera.ba/uspjesne-price/144/kako-je-adis-postao-devops-inzenjer");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement twitterButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".resp-sharing-button.resp-sharing-button--twitter.resp-sharing-button--medium")
        ));
        twitterButton.click();



        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://x.com/intent/post?text=Super+fast+and+easy+Social+Media+Sharing+Buttons.+No+JavaScript.+No+tracking.&url=https%3A%2F%2Fitkarijera.ba%2Fuspjesne-price%2F144%2Fkako-je-adis-postao-devops-inzenjer";
        assertTrue(actualUrl.equals(expectedUrl), "The Twitter sharing button did not redirect to the correct URL.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
