package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage {

    WebDriver driver;
    Actions actions;

    public ButtonsPage(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        PageFactory.initElements(Driver.getDriver(), this);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement dynamicClickBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public ButtonsPage clickDoubleBtn() throws InterruptedException {
        actions.doubleClick(doubleClickBtn).perform();
        Thread.sleep(5000);
        return this;
    }

    public ButtonsPage clickRightBtn() throws InterruptedException {
        actions.contextClick(rightClickBtn).perform();
        Thread.sleep(5000);
        return this;
    }

    public ButtonsPage clickMeBtn() throws InterruptedException {
        Thread.sleep(5000);
        webElementHelper.waitForButtonToBeClickAble(dynamicClickBtn);
        webElementHelper.click(dynamicClickBtn);
        return this;
    }


}
