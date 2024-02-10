package com.fall23.IU.pages.hwBookStoreApp;

import com.fall23.IU.drivers.Driver;
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

//    @FindBy(xpath = "div[class='recaptcha-checkbox-border']")
//    public WebElement clickToCaptcha;

    @FindBy(id = "register")
    public WebElement registerBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public RegistrationPage clickNewUserBtn(){
        newUserBtn.click();
        return this;
    }
    public RegistrationPage fillUpTheFirstName(String firstName){
        webElementHelper.sendKeys(firstNameInput, firstName);
        return this;
    }

    public RegistrationPage fillUpTheLAstName(String lastName){
        webElementHelper.sendKeys(lastNameInput, lastName);
        return this;
    }

    public RegistrationPage fillUpUserName(String userName){
        webElementHelper.sendKeys(userNameInput, userName);
        return this;
    }

    public RegistrationPage fillUpPassword(String password){
        webElementHelper.sendKeys(passwordInput, password)
                .scrollToElement(registerBtn);

        return this;
    }

    public RegistrationPage clickRegisterBtn() {
        registerBtn.click();
        return this;
    }

    public RegistrationPage clickOnCaptcha(WebDriver driver){
        WebElement iframe = driver.findElement(By.cssSelector("iframe[src*='recaptcha']"));
        driver.switchTo().frame(iframe);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.getElementById('recaptcha-anchor').click();");

        driver.switchTo().defaultContent();
        return this;
    }


}
