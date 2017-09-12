package com.yuliia.macademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameElement;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordElement;

    @FindBy(xpath = "//input[@type='submit']")
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
