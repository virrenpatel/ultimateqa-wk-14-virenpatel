package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By userNameField = By.id("user[email]");
    By passwordField = By.id("user[password]");
    By loginButton = By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]");
    By errorMessage = By.xpath("//li[contains(text(),'Invalid email or password.')]");

    public void enterUsername(String userName) {

        sendTextToElement(userNameField, userName);
    }

    public void enterPassword(String password) {

        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {

        clickOnElement(loginButton);
    }

    public String getErrorMessage() {

        return getTextFromElement(errorMessage);
    }



}
