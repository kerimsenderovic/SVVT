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

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Novosti"))
        );

        WebElement novostiLink = driver.findElement(By.linkText("Novosti"));
        novostiLink.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.urlToBe("https://itkarijera.ba/vijesti")
        );

        assertEquals("https://itkarijera.ba/vijesti", driver.getCurrentUrl(), "Failed to navigate to vijesti.");
    }
    @Test
    public void testNavigateToITKarijera() {
        driver.get(baseUrl);

        WebElement itKarijeraLink = driver.findElement(By.linkText("IT karijera"));
        itKarijeraLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdownContent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='item_31']")
        ));

        assertTrue(dropdownContent.isDisplayed(), "Dropdown content for IT karijera is not displayed.");
        System.out.println("Test Passed: IT karijera dropdown displayed.");
    }

    @Test
    public void FAQ() {
        driver.get(baseUrl);

        WebElement itKarijeraLink = driver.findElement(By.linkText("IT karijera"));
        itKarijeraLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement faqLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='tabletNavBar']/div/nav/div/ul/li[3]/div/span[5]/a")
        ));

        faqLink.click();

        wait.until(ExpectedConditions.urlToBe("https://itkarijera.ba/html-page/97/cesto-postavljana-pitanja-faq"));

        assertEquals("https://itkarijera.ba/html-page/97/cesto-postavljana-pitanja-faq", driver.getCurrentUrl(), "Failed to navigate to FAQ.");
    }

}
