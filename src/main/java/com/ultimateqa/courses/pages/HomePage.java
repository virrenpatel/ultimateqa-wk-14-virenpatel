package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By signInLink = By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]");
    By textWelcomeBack = By.xpath("//h1[@class = 'page__heading']");

    public void clickOnSignInLink(){
        clickOnElement(signInLink);
    }

    public String getTextWelcomeBack(){
        return getTextFromElement(textWelcomeBack);
    }
}
