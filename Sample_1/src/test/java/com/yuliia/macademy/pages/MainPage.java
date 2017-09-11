package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    private final String userProfilePicXPATH = "//*[contains(@class,'pull-right')]/li/a//*[contains(@class,'fa-user')]";

    @FindBy (className = "loginurl")
    private WebElement loginURLBtnElement;


    @FindBy (className = "userpicture")
    private WebElement defaultUserPicture;


    @FindBy (xpath = userProfilePicXPATH)
    private WebElement userProfileBtn;


    public MainPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickLogin (){
        loginURLBtnElement.click();
    }

    public void showMenu (){

        defaultUserPicture.click();
    }

    public void clickUserProfile (){

        userProfileBtn.click();
    }

}
