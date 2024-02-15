package com.fall23.IU.pages.hwBookStoreApp;

import com.fall23.IU.data.JavaFaker;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.BookStoreUser;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='newUser']")
    public WebElement newUserBtn;

    @FindBy(id = "firstname")
    public WebElement firstNameInput;

    @FindBy(id = "lastname")
    public WebElement lastNameInput;

    @FindBy(id = "userName")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='register']")
    public WebElement registerBtn;

    WebElementHelper webElementHelper = new WebElementHelper();
    JavaFaker faker = new JavaFaker();
    BookStoreUser randomBookStoreUser = JavaFaker.createNewUserOfBookSoreWithFakerData();

    public RegistrationPage fillTheForm(){
        webElementHelper
                .sendKeys(firstNameInput, randomBookStoreUser.getFirstname())
                .sendKeys(lastNameInput, randomBookStoreUser.getLastname());
        userNameInput.sendKeys("test");
        passwordInput.sendKeys("!!Testest2000");
        return this;
    }

    public RegistrationPage clickNewUserAndScroll(){
        webElementHelper.scrollToElement(newUserBtn);
        newUserBtn.click();
        return this;
    }

    public RegistrationPage clickRegisterBtn(){
        webElementHelper.click(registerBtn);
        return this;
    }


}
