package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCoursesPage extends Page{
    @FindBy(xpath = "//a[@title='Automated testing']")
    private WebElement automatedTestingURL;

    public MyCoursesPage (WebDriver driver) {
        super(driver);
    }
    public WebElement getAutomatedCourses (){
        return automatedTestingURL;
    }
}
