package com.yuliia.macademy.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        mainPage.clickLogin();
        loginPage.loginAction(userNameInput, userPasswordInput);
        mainPage.showMenu();
        mainPage.clickUserProfile();

        Assert.assertEquals(profilePage.getActualUserName(), "Юлія Мисюк", "Wrong user name");
        Assert.assertEquals(driver.getCurrentUrl(), userProfileURL, "Wrong user URL");
    }

    @Test
    public void testAvailableCourses() {
        mainPage.clickLogin();
        loginPage.loginAction(userNameInput, userPasswordInput);
        mainPage.showMenu();
        mainPage.clickUserProfile();
        profilePage.navigateToMyCourses();

        Assert.assertEquals(myCoursesPage.getAutomatedCourses().getText(),"Automated testing", "Automated testing course is not available" );
    }
}

