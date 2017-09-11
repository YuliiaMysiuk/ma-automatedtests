package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private WebDriver driver;

    private final String userProfileNameXPATH = "//div[@class='userprofile']/h2";
    private final String myCoursesURLXPATH = "//p[contains(@id, 'mycourses')]/a";


    @FindBy(xpath = userProfileNameXPATH)
    private WebElement actualUserName;

    @FindBy(xpath = myCoursesURLXPATH)
    private WebElement myCoursesURL;


    public ProfilePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getActualUserName(){
        return actualUserName.getText();
    }

    public void navigateToMyCourses(){
        myCoursesURL.click();
    }

}
