package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class Utility extends BaseTest {
    /**
     * this method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    /**
     * this method will send text to element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    /**
     * this method will get text to element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     * this method will count items
     */
    public int countItem(By by){
        List<WebElement> list=driver.findElements(by);
        return list.size();
    }

    //************************* Alert Methods *****************************************************

    /**
     *this method will send value to element
     */
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    /**
     *this method will accept alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    /**
     *this method will dismiss alert
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    /**
     *this method will get text from alert
     */
    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }

    //************************* Select Methods *****************************************************
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
    }
    public void selectByValueTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByValue(text);
    }
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByIndex(index);
    }
}
