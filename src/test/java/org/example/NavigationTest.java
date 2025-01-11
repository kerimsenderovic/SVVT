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

public class NavigationTest {

    private static WebDriver driver;
    private static String baseUrl;
    private static String baseUrl1;
    private static String baseUrl2;

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        baseUrl = "https://itkarijera.ba";
        baseUrl1="https://edu.itkarijera.ba/login/index.php";
        baseUrl2="https://itkarijera.ba/html-page/34/o-portalu";
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testNavigationToKakoIGdjePoceti() throws InterruptedException {

        driver.get(baseUrl);


        WebElement kakoPocetiButton = driver.findElement(By.cssSelector("a.btn.btn-red.text-light[href='/html-page/90/it-karijera-kako-i-gdje-poceti']"));


        kakoPocetiButton.click();


        Thread.sleep(2000);


        String currentUrl = driver.getCurrentUrl();


        String expectedUrl = "https://itkarijera.ba/html-page/90/it-karijera-kako-i-gdje-poceti";
        expectedUrl = expectedUrl.replaceAll("/+$", "");

        assertEquals(expectedUrl, currentUrl, "Navigation failed for 'Kako i gdje početi?' link");

        System.out.println("Test Passed: Navigation to 'Kako i gdje početi?' works correctly!");
    }
    @Test
    public void upistvo() throws InterruptedException {

        driver.get(baseUrl1);


        WebElement element = driver.findElement(By.xpath("//*[@id=\"page-content\"]/div/div[3]/div/div/div/div[2]/div[1]/ul/li[2]/a"));


        element.click();


        Thread.sleep(2000);


        String currentUrl = driver.getCurrentUrl();


        String expectedUrl = "https://edu.itkarijera.ba/login/index.php#tab-678255d187d121";
        expectedUrl = expectedUrl.replaceAll("/+$", "");

        assertEquals(expectedUrl, currentUrl, "Navigation failed ");



    }
    @Test
    public void facebook() throws InterruptedException {

        driver.get(baseUrl2);


        WebElement kakoPocetiButton = driver.findElement(By.xpath("/html/body/app-root/app-pages-home/main/app-html-page-view/div/div[2]/div[2]/div[1]/app-share-buttons/a[1]/div"));


        kakoPocetiButton.click();


        Thread.sleep(2000);


        String currentUrl = driver.getCurrentUrl();


        String expectedUrl = "https://www.facebook.com/share_channel/";
        expectedUrl = expectedUrl.replaceAll("/+$", "");

        assertEquals(expectedUrl, currentUrl, "Navigation failed ");


    }
}