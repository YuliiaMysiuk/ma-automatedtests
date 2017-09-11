package com.yuliia.macademy.tests;

import com.yuliia.macademy.pages.LoginPage;
import com.yuliia.macademy.pages.MainPage;
import com.yuliia.macademy.pages.MyCoursesPage;
import com.yuliia.macademy.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private String mainAcademyURL = "http://lms.mainacad.com/";
    private String userNameInput = "iuliia_mysiuk";
    private String userPasswordInput = "Iuliia_Mysiuk06";
    private String userProfileURL = "http://lms.mainacad.com/user/profile.php?id=3563";

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
    public void testLogin() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);


        mainPage.clickLogin();
        loginPage.loginAction(userNameInput, userPasswordInput);
        mainPage.showMenu();
        mainPage.clickUserProfile();

        Assert.assertEquals(profilePage.getActualUserName(), "Юлія Мисюк", "Wrong user name");
        Assert.assertEquals(driver.getCurrentUrl(), userProfileURL, "Wrong user URL");
    }

    @Test
    public void testAvailableCourses() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        MyCoursesPage myCoursesPage = new MyCoursesPage(driver);

        mainPage.clickLogin();
        loginPage.loginAction(userNameInput, userPasswordInput);
        mainPage.showMenu();
        mainPage.clickUserProfile();
        profilePage.navigateToMyCourses();

        Assert.assertEquals(myCoursesPage.getAutomatedCourses().getText(),"Automated testing", "Automated testing course is not available" );
    }
}

