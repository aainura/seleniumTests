package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    @Test
    public void testPartialLink() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.partialLinkText("Search")).click();
       Thread.sleep(2000);
        String expectedTitle = "Discover How Google Search Works";

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        driver.close();

    }

    @Test
    public void testSearch() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        driver.findElement(By.name("q")).sendKeys("Australia"+ Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Australia"));


    }
    @Test
    public void testAmazonHello() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("nav-hamburger-menu")).click();
        Thread.sleep(2000);

        WebElement text = driver.findElement(By.id("hmenu-customer-name"));
        Assert.assertTrue(text.isDisplayed());

    }
    @Test
    public void testPracticeSelenium() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.practiceselenium.com/");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Let's Talk Tea")).click();
        Thread.sleep(2000);

        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("John");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("abc123@gmail.com");

        WebElement field = driver.findElement(By.name("subject"));
        field.sendKeys("special request");

        WebElement message = driver.findElement(By.name("message"));
        message.sendKeys("Thanks");

        driver.findElement(By.className("form-submit")).click();
    }
}
