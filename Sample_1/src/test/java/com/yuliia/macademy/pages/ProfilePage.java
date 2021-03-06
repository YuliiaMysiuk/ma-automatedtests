package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Page{
    @FindBy(xpath = "//div[@class='userprofile']/h2")
    private WebElement actualUserName;

    @FindBy(xpath = "//p[contains(@id, 'mycourses')]/a")
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
