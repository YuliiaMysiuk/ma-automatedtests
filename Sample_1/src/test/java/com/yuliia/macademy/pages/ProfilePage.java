package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Page{
    private final String userProfileNameXPATH = "//div[@class='userprofile']/h2";
    private final String myCoursesURLXPATH = "//p[contains(@id, 'mycourses')]/a";

    @FindBy(xpath = userProfileNameXPATH)
    private WebElement actualUserName;

    @FindBy(xpath = myCoursesURLXPATH)
    private WebElement myCoursesURL;

    public ProfilePage (WebDriver driver) {
        super(driver);
    }

    public String getActualUserName(){
        return actualUserName.getText();
    }

    public void navigateToMyCourses(){
        myCoursesURL.click();
    }

}
