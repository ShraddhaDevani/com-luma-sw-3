package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will send text on Element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * selectByValueFromDropDown is generic method to select element by Value from dropdown
     */
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown); //Create object of select class
        select.selectByValue(value);
    }
    /**
     * selectByIndexFromDropDown is generic method to select element by text from dropdown
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown); //Create object of select class
        select.selectByVisibleText(text);
    }
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by); //Create object of select class
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    /**
     * mouseHover is generic method for move to the specific element and click on it
     */
    public void mouseHover(By by){
        Actions actions = new Actions(driver); //Create object of alert class
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * mouseHover is generic method for move to the specific element and click on it
     */
    public void mouseHoverAndClick(By by){
        Actions actions = new Actions(driver); //Create object of alert class
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    /**
     * switchToAlert is generic method to switch to Alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }

    /**
     * acceptToAlert is generic method to accept the Alert
     */
    public void acceptToAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * dismissAlert is generic method to dismiss the Alert
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    /**
     * getTextFromAlert is generic method to return the text from Alert
     */
    public String getTextFromAlert(){
        return driver.switchTo().alert().getText();
    }

    /**
     * sendTextToAlert is generic method to send Text to Alert
     */
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    /**
     * This method is for verifying the text
     */
    /**
     * This method will verify text
     */

    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String Message = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, Message);
    }
}


