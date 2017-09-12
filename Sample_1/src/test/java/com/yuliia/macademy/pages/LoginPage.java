package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    private final String userNameInputXPATH = "//input[@name='username']";
    private final String userPasswordInputXPATH = "//input[@type='password']";
    private final String loginBtnXPATH = "//input[@type='submit']";

    @FindBy(xpath = userNameInputXPATH)
    private WebElement userNameElement;

    @FindBy(xpath = userPasswordInputXPATH)
    private WebElement passwordElement;

    @FindBy(xpath = loginBtnXPATH)
    private WebElement loginBtnElement;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public void loginAction (String suserName, String spassword){
        userNameElement.sendKeys(suserName);
        passwordElement.sendKeys(spassword);
        loginBtnElement.submit();
    }
}
