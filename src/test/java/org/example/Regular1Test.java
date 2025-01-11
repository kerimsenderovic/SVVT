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

public class Regular1Test {

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
    public void testEmailInputAndWait() {

        driver.get(baseUrl + "/html-page/68/it-sektor-u-bih");


        WebElement emailInputField = driver.findElement(By.cssSelector("input[aria-label='Email']"));


        String randomEmail = "acadidaadi@fadfddf.com";
        emailInputField.sendKeys(randomEmail);


        WebElement submitButton = driver.findElement(By.cssSelector("button.emailbutton.btn.input-group-text.text-red"));


        submitButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation-message-id")));


        assertTrue(confirmationMessage.isDisplayed(), "Confirmation message not displayed after submitting the form.");

        System.out.println("Test Passed: Clicked on the submit button and confirmation message appears.");
    }
}
