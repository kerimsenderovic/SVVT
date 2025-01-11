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
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));
        assertTrue(footer.isDisplayed(), "Footer is not displayed on the page.");

        WebElement footerLinksContainer = driver.findElement(By.cssSelector("footer .footer-links"));
        List<WebElement> footerLinks = footerLinksContainer.findElements(By.tagName("a"));

        for (WebElement link : footerLinks) {
            String linkText = link.getText();
            String linkUrl = link.getAttribute("href");

            System.out.println("Verifying link: " + linkText + " (" + linkUrl + ")");

            assertTrue(linkUrl != null && !linkUrl.isEmpty(), "Link URL is empty for: " + linkText);

            ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", linkUrl);


            Navigation navigation = driver.navigate();
            String currentTab = driver.getWindowHandle();
            for (String tab : driver.getWindowHandles()) {
                if (!tab.equals(currentTab)) {
                    driver.switchTo().window(tab);
                }
            }

            wait.until((ExpectedCondition<Boolean>) d -> d.getCurrentUrl().equals(linkUrl));


            String actualUrl = driver.getCurrentUrl();
            assertEquals(linkUrl, actualUrl, "Failed to navigate to the correct page for link: " + linkText);

            driver.close();
            driver.switchTo().window(currentTab);


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));
        }

        System.out.println("Test Passed: All footer links are functional and lead to correct pages.");
    }
}
