package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RadioButtonPage {

    public RadioButtonPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[@for='yesRadio']")
    public WebElement yesRadioBtn;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    public WebElement impressiveRadioBtn;

    @FindBy(xpath = "//label[@for='noRadio']")
    public WebElement noRadioBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public RadioButtonPage clickYesButton(){
        webElementHelper.click(yesRadioBtn);
        return this;
    }

    public RadioButtonPage clickImpressiveRadioButton(){
        webElementHelper.click(impressiveRadioBtn);
        return this;
    }

    public RadioButtonPage clickNoRadioButton(){
        webElementHelper.click(noRadioBtn);
        return this;
    }
}
