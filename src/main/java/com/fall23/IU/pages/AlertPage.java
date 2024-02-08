package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    public AlertPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "alertButton")
    public WebElement alertBtn;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertBtn;

    @FindBy(id = "confirmButton")
    public WebElement confirmBtn;

    @FindBy(id = "promtButton")
    public WebElement promtBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public AlertPage clickAlertBtn(){
        webElementHelper.click(alertBtn);
        return this;
    }

    public AlertPage clickTimerAlertBtn(){
        webElementHelper.click(timerAlertBtn);
        return this;
    }

    public AlertPage clickConfirmBtn(){
        webElementHelper.click(confirmBtn);
        return this;
    }

    public AlertPage clickPromptBtn(){
        webElementHelper.click(promtBtn);
        return this;
    }


}
