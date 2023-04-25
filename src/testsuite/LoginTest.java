package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseURL="https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text “PRODUCTS”
        String actualText=getTextFromElement(By.xpath("//span[@class='title']"));
        String expectedText="Products";
        Assert.assertEquals("Text displayed not correctly",expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify that six products are displayed on page
        int actualSize= countItem(By.xpath("//div[@class='inventory_item']"));
        int expectedSize=6;
        Assert.assertEquals("There is not 6 products",expectedSize,actualSize);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
