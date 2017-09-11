package com.yuliia.macademy.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class MainAcademyLoginTest {
    private WebDriver driver;
    private String mainAcademyURL = "http://lms.mainacad.com/";
    private String userProfileURL = "http://lms.mainacad.com/user/profile.php?id=3563";
    private String userNameInput = "iuliia_mysiuk";
    private String userPasswordInput = "Iuliia_Mysiuk06";

    @BeforeSuite
    public void initDriver() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(mainAcademyURL);
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testLoginToMainAcademy(){
        loginToPage();

        // login btn has changed to custom user pic
        // hover over userpic to see submenu
        WebElement userPictureElement = driver.findElement(By.className("userpicture"));
        userPictureElement.click();

        // click on userprofile
        WebElement userProfileBtn = driver.findElement(By.xpath("//*[contains(@class,'pull-right')]/li/a//*[contains(@class,'fa-user')]"));
        userProfileBtn.click();

        WebElement actualUserName = driver.findElement(By.xpath("//div[@class='userprofile']/h2"));
        Assert.assertEquals(actualUserName.getText(),"Юлія Мисюк", "Wrong user name");
        Assert.assertEquals(driver.getCurrentUrl(), userProfileURL, "Wrong user URL");
    }


    @Test
    public void testAvailableCourses () {
        loginToPage();

        WebElement userPictureElement = driver.findElement(By.className("userpicture"));
        userPictureElement.click();

        WebElement userProfileBtn = driver.findElement(By.xpath("//*[contains(@class,'pull-right')]/li/a//*[contains(@class,'fa-user')]"));
        userProfileBtn.click();

        WebElement myCoursesURL = driver.findElement(By.xpath("//p[contains(@id, 'mycourses')]/a"));
        myCoursesURL.click();

        WebElement courseMenuElement = driver.findElement(By.xpath("//a[@title='Automated testing']"));
        Assert.assertEquals(courseMenuElement.getText(),"Automated testing", "Automated testing course is not available" );
    }

    private void loginToPage (){
        // go to the page and click on login Btn
        WebElement loginURLBtnElement = driver.findElement(By.xpath("//a[@class='loginurl']"));
        loginURLBtnElement.click();

        WebElement userNameElement = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginBtnElement = driver.findElement(By.xpath("//input[@type='submit']"));

        // login
        userNameElement.sendKeys(userNameInput);
        passwordElement.sendKeys(userPasswordInput);
        loginBtnElement.submit();
    }
}
