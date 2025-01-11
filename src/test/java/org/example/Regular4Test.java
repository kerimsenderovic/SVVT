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


public class Regular4Test {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba/dogadjaji";
    }

    @Test
    public void testCalendarNextButton() {
        driver.get(baseUrl);

        WebElement element=driver.findElement(By.xpath("/html/body/app-root/app-pages-home/main/app-events/div/app-events-calendar/div/app-calendar-header/div/div/nav/a/div/div/div/a[2]/i"));
        element.click();
        assertEquals("https://itkarijera.ba/dogadjaji?filter=%7B%22month%22:2,%22year%22:2025%7D", driver.getCurrentUrl());


    }
    @Test
    public void testCalendarNextButton1() {
        driver.get("https://itkarijera.ba/dogadjaji?filter=%7B%22month%22:2,%22year%22:2025%7D");

        WebElement element=driver.findElement(By.xpath("/html/body/app-root/app-pages-home/main/app-events/div/app-events-calendar/div/app-calendar-header/div/div/nav/a/div/div/div/a[2]/i"));
        element.click();
        assertEquals("https://itkarijera.ba/dogadjaji?filter=%7B%22month%22:3,%22year%22:2025%7D", driver.getCurrentUrl());


    }
    @Test
    public void testCalendarNextButton2() {
        driver.get("https://itkarijera.ba/dogadjaji?filter=%7B%22month%22:3,%22year%22:2025%7D");

        WebElement element=driver.findElement(By.xpath("/html/body/app-root/app-pages-home/main/app-events/div/app-events-calendar/div/app-calendar-header/div/div/nav/a/div/div/div/a[1]/i"));
        element.click();
        assertEquals("https://itkarijera.ba/dogadjaji?filter=%7B%22month%22:2,%22year%22:2025%7D", driver.getCurrentUrl());


    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
