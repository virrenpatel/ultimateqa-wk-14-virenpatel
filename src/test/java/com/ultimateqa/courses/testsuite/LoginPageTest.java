package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    HomePage homepage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        homepage.clickOnSignInLink();
        String expectedMessage = "Welcome Back!";
        String actualMessage = homepage.getTextWelcomeBack();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");

    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {
        homepage.clickOnSignInLink();
        loginPage.enterUsername("123test@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }
}
