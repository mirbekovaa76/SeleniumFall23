package com.fall23.DEMOQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static com.fall23.DEMOQA.WebDriverManager.driver;

public class WebElementManager {

    // 1. by ID
    public static WebElement findElementById(String ID){
        return driver.findElement(By.id(ID));
    }
    public static void findElementByIdAndSendKeys(String ID, String data){
        driver.findElement(By.id(ID)).sendKeys(data);
    }

    // 2. by Name
    public static WebElement findElementByName(String name){
        return driver.findElement(By.name(name));

    }
    public static void findElementByNameAndSendKeys(String name, String data){
        driver.findElement(By.name(name)).sendKeys(data);
    }

    // 3. by Tag
    public static WebElement findElementByTag(String tag){
        return driver.findElement(By.tagName(tag));
    }
    public static void findElementByTagAndClick(String tag){
        driver.findElement(By.tagName(tag)).click();
    }

    // 4. by Class name
    public static WebElement findElementByClassName(String className){
        return driver.findElement(By.className(className));
    }

    // 5. by Link Text
    public static WebElement findElementByLinkText(String linkName){
        return driver.findElement(By.linkText(linkName));
    }
    public static void findElementByLinkTextAndClick(String linkName){
        driver.findElement(By.linkText(linkName)).click();
    }

    // 6. by Partial Link Text
    public static WebElement findElementByPartialLinkText(String linkName){
        return driver.findElement(By.partialLinkText(linkName));
    }
    public static void findElementByPartialLinkTextAndClick(String linkName){
        driver.findElement(By.partialLinkText(linkName)).click();
    }

    // 7. by XPath
    public static WebElement findElementByXPath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public static void findElementByXPathAndSendKeys(String xpath, String data){
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    // 8. by CssSelector
    public static WebElement findElementByCssSelector(String selectorName){
        return driver.findElement(By.cssSelector(selectorName));
    }

    // 9. scrolling
    public static void scrollPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)");
    }

    // scrolling actions
//    public static void scrollDownWebPage(){
//        actions = new Actions(driver);
//        actions.scrollByAmount(0, 500).perform();
//    }

}

