package com.crio.QKART_TestNG.pages;

import java.sql.Timestamp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class Register {
    WebDriver driver;
    String url = "https://crio-qkart-frontend-qa.vercel.app/register"; 
    public String lastGeneratedUsername = "";

    @FindBy(id="username")
    WebElement username_txt_box;

    @FindBy(id="password")
    WebElement password_txt_box;

    @FindBy(id="confirmPassword")
    WebElement confirm_password_txt_box;

    @FindBy(className = "button")
    WebElement register_now_button;

    public Register(WebDriver driver)
    {
     this.driver = driver;   
    }

    public void navigateToRegisterPage()
    {
        if(!driver.getCurrentUrl().equals(this.url))
        {
            driver.get(this.url);
            PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        }
    }

    public Boolean registerUser(String Username , String Password, Boolean makeUsernameDynamic ) throws InterruptedException
    {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // Get time stamp for generating a unique username 
        String test_data_username;
        if(makeUsernameDynamic)
            test_data_username = Username+"_"+String.valueOf(timestamp.getTime()); //concatenate the timestamp to string to form unique timestamp
        else
            test_data_username = Username;
        WrapperMethods.advancedSendkeys(username_txt_box, test_data_username);
        String test_data_password = Password;
        WrapperMethods.advancedSendkeys(password_txt_box, test_data_password);
        WrapperMethods.advancedSendkeys(confirm_password_txt_box, test_data_password);
        WrapperMethods.advancedClick(register_now_button);
        this.lastGeneratedUsername = test_data_username;
        WebDriverWait wait = new WebDriverWait(driver,30);     
        wait.until(ExpectedConditions.urlToBe("https://crio-qkart-frontend-qa.vercel.app/login"));
        return this.driver.getCurrentUrl().endsWith("/login");
    }
}
