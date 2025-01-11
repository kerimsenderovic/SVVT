package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://edu.itkarijera.ba/login/index.php";
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithInvalidCredentials() {

        driver.get(baseUrl);


        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginbtn"));

        usernameField.sendKeys("wronguser");
        passwordField.sendKeys("wrong123");
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));
        String expectedErrorMessage = "Pogrešno korisničko ime ili lozinka. Molimo pokušajte ponovo.";
        String actualErrorMessage = errorMessage.getText();

        assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed for invalid credentials");

        System.out.println("Test Passed: Invalid credentials show error message.");
    }

    @Test
    public void testLoginWithBlankFields() {

        driver.get(baseUrl);


        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));
        String expectedErrorMessage = "Both fields are required.";
        String actualErrorMessage = errorMessage.getText();

        assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed for empty fields");

        System.out.println("Test Passed: Validation error shown for empty fields.");
    }
}