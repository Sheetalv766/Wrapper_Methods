package com.crio.QKART_TestNG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WrapperMethods {

    public static void wrap_sendKeys(WebElement e, String inputText) throws InterruptedException {
        // TODO: WRAPPER METHODS: MILESTONE 2 ACTIVITY
        // e --> element
        // before entering the text textbox is clear
        e.clear();
        Thread.sleep(1000);

        e.sendKeys(inputText);
        Thread.sleep(1000);
    }


    public static WebElement wrap_findElement(RemoteWebDriver driver, By b) {
        // 2 parameters --> RemoteWebDriver and By
        // By --> By class of selenium
        // By --> any locator to pass --> id, className

        // TODO: WRAPPER METHODS: MILESTONE 2 ACTIVITY

        return driver.findElement(b);
    }


    public static void advancedClick(WebElement e) throws InterruptedException {
        // TODO: Wrapper METHODS: Milestone 4 Activity

        // WebElement e--> e is here webelement as a parameter
        Point p = e.getLocation();

        // Print the x,y coordinates of the element on the web page
        System.out.println("Location is : " + p.getX() + "," + p.getY());

        // Click on the element [Usual click ()]
        e.click();
        Thread.sleep(2000);

        // Check if the element still exists on the page and print the status
        try {
            e.isDisplayed();
            System.out.println("Element is still exists on the page");
        } catch (Exception ex) {
            System.out.println("Element is not exists on the page");
        }
    }


    public static void advancedSendkeys(WebElement e, String inputText) {
        // TODO: Wrapper METHODS: Milestone 4 Activity

        // Print the number of characters in the input text
        int charCount = inputText.length();
        System.out.println("Number of characters in the input text : " + charCount);

        // Type the text on the given element [ Usual Send Keys () ]
        e.sendKeys(inputText);

        // Get the innerhtml of the given webelement and print the same
        String innerHTML = e.getAttribute("innerHTML");
        System.out.println("Inner Html of the WebElement : " + innerHTML);
    }
}
