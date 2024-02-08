package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage { // страница CheckBox вся здесь

    public CheckBoxPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@aria-label='Toggle']/child::*)[1]")
    public WebElement homeBtn;

    @FindBy(xpath = "(//button[@aria-label='Toggle']/child::*)[2]")
    public WebElement desktopBtn;

    @FindBy(xpath = "(//button[@aria-label='Toggle']/child::*)[3]")
    public WebElement documentsBtn;

    @FindBy(xpath = "(//button[@aria-label='Toggle']/child::*)[6]")
    public WebElement downloadsBtn;

    @FindBy(xpath = "//span[text()='Desktop']")
    public WebElement selectAllDesktopFilesBtn;

    @FindBy(xpath = "//span[text()='Documents']")
    public WebElement selectAllDocumentsFilesBtn;

    @FindBy(xpath = "//span[text()='Downloads']")
    public WebElement selectAllDownloadsFilesBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public CheckBoxPage clickHomeBtn(){
        webElementHelper.click(homeBtn);
        return this;
    }

    public CheckBoxPage clickDesktopBtn(){
        webElementHelper.click(desktopBtn);
        return this;
    }

    public CheckBoxPage clickDocumentsBtn(){
        webElementHelper.click(documentsBtn);
        return this;
    }

    public CheckBoxPage clickDownloadsBtn(){
        webElementHelper.click(downloadsBtn);
        return this;
    }

    public CheckBoxPage clickAndSelectAllDesktopFiles(){
        webElementHelper.click(selectAllDesktopFilesBtn);
        return this;
    }

    public CheckBoxPage clickAndSelectAllDocumentsFiles(){
        webElementHelper.click(selectAllDocumentsFilesBtn);
        return this;
    }

    public CheckBoxPage clickAndSelectAllDownloadsFiles(){
        webElementHelper.click(selectAllDownloadsFilesBtn);
        return this;
    }
}
