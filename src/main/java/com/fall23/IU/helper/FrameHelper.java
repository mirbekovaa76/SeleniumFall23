package com.fall23.IU.helper;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    public FrameHelper(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public FrameHelper swithcToFrame(WebElement element){
        try{
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException e){
            e.printStackTrace();
        }
        return this;
    }

    // переключение к родительскому фрейму
    public FrameHelper switchToParentFrame(){
        driver.switchTo().parentFrame();
        return this;
    }
}
