package com.fall23.IU.pages.hwBookStoreApp;

import com.fall23.IU.data.JavaFaker;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.BookStoreUser;
import com.fall23.IU.helper.WebElementHelper;
import com.github.javafaker.Faker;
import lombok.extern.java.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement loginBtn;

    @FindBy(id = "userName")
    public WebElement userNameLoginInput;

    @FindBy(id = "password")
    public WebElement passwordLoginInput;

    @FindBy(xpath = "//button[text()='Log out']")
            public WebElement logOutBtn;

    WebElementHelper webElementHelper = new WebElementHelper();
    public LoginPage fillUpUserNameInput(String userName){
        webElementHelper.sendKeys(userNameLoginInput, userName);
        return this;
    }

    public LoginPage fillUpPassword(String password){
        webElementHelper.sendKeys(passwordLoginInput, password);
        return this;
    }

    public LoginPage clickLoginBtn(){
        webElementHelper.click(loginBtn);
        return this;
    }

    public LoginPage clickLogoutBtn(){
        logOutBtn.click();
        return this;
    }
}
