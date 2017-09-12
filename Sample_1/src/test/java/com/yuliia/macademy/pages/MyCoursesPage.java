package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCoursesPage extends Page{
    private final String automatedTestingElementXPATH = "//a[@title='Automated testing']";

    @FindBy(xpath = automatedTestingElementXPATH)
    private WebElement automatedTestingURL;

    public MyCoursesPage (WebDriver driver) {
        super(driver);
    }
    public WebElement getAutomatedCourses (){
        return automatedTestingURL;
    }
}
