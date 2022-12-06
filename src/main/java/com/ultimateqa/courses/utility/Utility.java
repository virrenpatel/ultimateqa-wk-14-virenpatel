package com.ultimateqa.courses.utility;

import com.google.common.base.Function;
import com.ultimateqa.courses.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class Utility extends ManageBrowser {
    //This method will click on element. (Method  with no return type with  Parameter)

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    // This method will send text on element.(Method  with no return type with  Parameter)

    public void sendTextToElement(By by, String text) {
        WebElement emailField = driver.findElement(by);
        // Type email to email field
        emailField.sendKeys(text);

    }

    //This method will get text from element.(Method with  return type with Parameter)

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
//    public void verifyExpectedAndActual(By by, String expectedText) {
//        String actualText = getTextFromElement(by);
//        Assert.assertEquals(expectedText, actualText);
//
//    }
//    public void verifyMessage(String expectedMessage, String actualMessage) {
//        Assert.assertEquals(expectedMessage, actualMessage);
//
//    }

    //***************************Alert Methods **************************

    // this method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    // This method will accept alert

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // This method will dismiss alert

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //This method will get text from alert

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    // This method will send text from alert

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //***********************Select Class Methods ************************

    // This method will select option by visible text

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    // This method will select the option by value

    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    // This method will select the option by index

    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    // This method will select the option by contains text

    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

//    public void selectByContainsTextFromDropDown1(By by, String text) {
//        List<WebElement> allOptions = (new Select(driver.findElement(by))).getOptions();
//        Iterator var4 = allOptions.iterator();
//
//        while (var4.hasNext()) {
//            WebElement options = (WebElement) var4.next();
//            if (options.getText().contains(text)) {
//                options.click();
//            }
//        }
//
//    }

    //*************************** Window Handle Methods ***************************************//

    //This method will close all windows
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }
    //This method will switch to parent window
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    //This method will find that we switch to right window
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //*************************** Action Methods ***************************************//

    // This method will use to hover mouse on element

    //mouseHoverToElement(By by),
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        //WebElement computer = driver.findElement(by);
        //actions.moveToElement(computer).build().perform();
    }

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        // WebElement software = driver.findElement(by);
        // actions.moveToElement(software).click().build().perform();
    }
    //Drag and Drop Element
    public void dragAndDrop(By by, By by1) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(by), driver.findElement(by1)).build().perform();
        //WebElement draggable = driver.findElement(By.id("draggable"));
        //WebElement droppable = driver.findElement(By.id("droppable"));
        //actions.dragAndDrop(draggable, droppable).build().perform();
    }
    //***************************Clear Text *************************************************
    public void clearText(By by) {
        Actions actions = new Actions(driver);
        WebElement quantity = driver.findElement(by);
        quantity.clear();
    }

    //************************** Waits Methods *********************************************//

    //This method will use to wait until  VisibilityOfElementLocated

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

}
