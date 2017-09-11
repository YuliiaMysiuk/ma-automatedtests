package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    private final String userNameInputXPATH = "//input[@name='username']";
    private final String userPasswordInputXPATH = "//input[@type='password']";
    private final String loginBtnXPATH = "//input[@type='submit']";

    @FindBy(xpath = userNameInputXPATH)
    private WebElement userNameElement;

    @FindBy(xpath = userPasswordInputXPATH)
    private WebElement passwordElement;

    @FindBy(xpath = loginBtnXPATH)
    private WebElement loginBtnElement;

    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void loginAction (String suserName, String spassword){
        userNameElement.sendKeys(suserName);
        passwordElement.sendKeys(spassword);
        loginBtnElement.submit();
    }
}
