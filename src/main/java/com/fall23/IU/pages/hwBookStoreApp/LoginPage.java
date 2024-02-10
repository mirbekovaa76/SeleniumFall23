package com.fall23.IU.pages.hwBookStoreApp;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import lombok.extern.java.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "userName")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login")
    public WebElement loginBtn;

    @FindBy(xpath = "//button[text()='Log out']")
            public WebElement logOutBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public LoginPage fillUpUserNameInput(String userName){
        webElementHelper.sendKeys(userNameInput, userName);
        return this;
    }

    public LoginPage fillUpPassword(String password){
        webElementHelper.sendKeys(passwordInput, password);
        return this;
    }

    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }

    public LoginPage clickLogoutBtn(){
        logOutBtn.click();
        return this;
    }
}
