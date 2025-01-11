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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
    @Test
    public void testEmailInputAndWait1() {

        driver.get(baseUrl + "/html-page/68/it-sektor-u-bih");


        WebElement emailInputField = driver.findElement(By.cssSelector("input[aria-label='Email']"));


        String randomEmail = "ggggg@gmail.com";
        emailInputField.sendKeys(randomEmail);


        WebElement submitButton = driver.findElement(By.cssSelector("button.emailbutton.btn.input-group-text.text-red"));


        submitButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
