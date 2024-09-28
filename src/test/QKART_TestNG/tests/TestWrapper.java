package com.crio.QKART_TestNG.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import com.beust.jcommander.WrappedParameter;
import com.crio.QKART_TestNG.WrapperClass;
import com.crio.QKART_TestNG.pages.WrapperMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWrapper {


    static RemoteWebDriver driver;

    @BeforeClass(alwaysRun = true, enabled = false)
    public static void createDriver() throws MalformedURLException {

        System.out.println("Initializing driver for TestWrapper unit tests");

        // Code to Launch Browser using Zalenium in Crio workspace
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
    }

    /*
     * Try out your wrapper methods by writing unit tests here
     */

    @Test(enabled = false)
    public void wrap_sendKeysUnitTest() throws InterruptedException {

        // Going to www.google.com
        driver.get("https://www.google.com");
        Thread.sleep(2000);

        // Use your wrapper method to send keys to the search bar
        WebElement searchBar = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        WrapperMethods.wrap_sendKeys(searchBar, "This is a Wrapper Method");

        // Repeat the method with a different string.
        WrapperMethods.wrap_sendKeys(searchBar, "This is the another String message");
    }


    @Test(enabled = false)
    public void wrap_findElement(String fileName) {

        // Going to QKart website register page
        driver.get("https://crio-qkart-frontend-qa.vercel.app/register");

        // Locating and printing the text in “Register Now” button
        WebElement regNowBtn = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        System.out.println("Register Now Button Text : " + regNowBtn.getText());

        // Try to locate an element with an incorrect locator
        try {
            WebElement inCrrLocator = driver.findElement(By.xpath("//div[@type='button']"));
        } catch (Exception e) {
            // save the screenshot
            captureScreenshot(fileName);
        }
    }

    @Test(enabled = false)
    public void advancedClickUnitTest() throws InterruptedException {

        // Going to QKart website register page
        driver.get("https://crio-qkart-frontend-qa.vercel.app/register");

        // Locating and printing the text in “Register Now” button
        WebElement regBtn = driver.findElement(By.className("button"));
        // System.out.println("Register Now Button Text : " + regNowBtn.getText());
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));

        // Clicking on the register now button without filling the fields
        WrapperMethods.advancedClick(regBtn);
        Thread.sleep(3000);

        // Filling the fields, then clicking on the register now button
        username.sendKeys("username@1234567");
        password.sendKeys("username@1234567");
        confirmPassword.sendKeys("username@1234567");
        WrapperMethods.advancedClick(regBtn);
        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void advancedSendKeysUnitTest(WebElement fullNameField2, String string)
            throws InterruptedException {

        // Going to QKart website register page
        driver.get("https://crio-qkart-frontend-qa.vercel.app/register");

        // Applying advancedSendKeys method to all the fields in the register page
        WebElement fullNameField = driver.findElement(By.id("fullName"));
        WrapperMethods.advancedSendkeys(fullNameField, "Sheetal Verma");

        WebElement emailField = driver.findElement(By.id("email"));
        WrapperMethods.advancedSendkeys(emailField, "vermasheetu8855@gmail.com");

        WebElement passwordFiled = driver.findElement(By.id("password"));
        WrapperMethods.advancedSendkeys(passwordFiled, "1234567");

        WebElement confirmPassField = driver.findElement(By.id("confirmPassword"));
        WrapperMethods.advancedSendkeys(confirmPassField, "1234567");
    }


    private void captureScreenshot(String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass(enabled = false)
    public static void quitDriver() {
        System.out.println("Ending TestWrapper and unit tests");
        driver.quit();
    }
}
