package com.yuliia.macademy.tests;

import com.yuliia.macademy.pages.LoginPage;
import com.yuliia.macademy.pages.MainPage;
import com.yuliia.macademy.pages.MyCoursesPage;
import com.yuliia.macademy.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {

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

