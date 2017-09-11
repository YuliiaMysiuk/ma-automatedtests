package com.yuliia.macademy.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTest1 {

    private WebDriver driver;

    @BeforeSuite
    public void initDriver() throws Exception {
        System.out.println("You are testing in Firefox");
//      System.setProperty("webdriver.gecko.driver", "/opt/SeleniumDrivers/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void searchTestNGInGoogle() {
        final String searchKey = "TestNG";
        System.out.println("Search " + searchKey + " in google");
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));  // <input name="q"
        System.out.println("Enter " + searchKey);
        element.sendKeys(searchKey);
        System.out.println("submit");
        element.submit();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("TestNG - Welcome")));

        System.out.println("Got " + searchKey + " results");
    }

    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}