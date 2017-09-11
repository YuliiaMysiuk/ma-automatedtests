package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursesPage {
    private WebDriver driver;

    private final String automatedTestingElementXPATH = "//a[@title='Automated testing']";

    @FindBy(xpath = automatedTestingElementXPATH)
    private WebElement automatedTestingURL;

    public MyCoursesPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public WebElement getAutomatedCourses (){
        return automatedTestingURL;
    }

}
