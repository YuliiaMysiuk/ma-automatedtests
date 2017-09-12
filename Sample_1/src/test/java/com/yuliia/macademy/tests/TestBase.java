package com.yuliia.macademy.tests;

import com.yuliia.macademy.pages.LoginPage;
import com.yuliia.macademy.pages.MainPage;
import com.yuliia.macademy.pages.MyCoursesPage;
import com.yuliia.macademy.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected String mainAcademyURL = "http://lms.mainacad.com/";
    protected String userNameInput = "iuliia_mysiuk";
    protected String userPasswordInput = "Iuliia_Mysiuk06";
    protected String userProfileURL = "http://lms.mainacad.com/user/profile.php?id=3563";

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;
    protected MyCoursesPage myCoursesPage;

    @BeforeSuite
    public void initDriver() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        myCoursesPage = new MyCoursesPage(driver);
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
}
