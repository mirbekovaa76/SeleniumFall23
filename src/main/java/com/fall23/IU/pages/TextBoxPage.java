package com.fall23.IU.pages; // pages - каждая страница приложения (сайта) будет тут

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage { // 1 из страниц нашего веб приложения хранится в одном классе (и методы для этой страницы только, ввести имя, адрес и т.д.)
                                            // заполняем же эти поля только тут
    // а методы страницу вниз и т.д. это общие методы для всех

    public TextBoxPage(){
        PageFactory.initElements(Driver.getDriver(), this); // изучить
        // FindBy не работает без PageFactory
        // т.е. он ищет через FindBy и под капотом инициализирует с помощью PageFactory
    }

    // аннотация TestNG для поиска элементов (вместо методов finById,xpath и т.д.)
    @FindBy(id = "userName") // под капотом всё равно ищет по ID (driver.findById("userName"))
    public WebElement fullNameInput;

    @FindBy(id = "userEmail") // вместо id можно и по xpath, css,class name, tag name и т.д.
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAdressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    // заполнение поля fullName
    public TextBoxPage fillUpFullName(String fullName){
        webElementHelper.sendKeys(fullNameInput, fullName);
        return this;
    }

    // заполнение поля email
    public TextBoxPage fillUpEmail(String email){
        webElementHelper.sendKeys(emailInput, email);
        return this;
    }

    // заполнение поля currentAddress
    public TextBoxPage fillUpCurrentAdress(String currentAdress){
        webElementHelper.sendKeys(currentAdressInput, currentAdress);
        return this;
    }

    // заполнение поля permanentAddress
    public TextBoxPage fillUpPermanentAdress(String permanentAdress){
        webElementHelper.sendKeys(permanentAddressInput, permanentAdress);
        return this;
    }

    // клик кнопки submit
    public TextBoxPage clickSubmitBtn(){
        webElementHelper.scrollToElement(submitBtn) // скроллит до элемента
                        .click(submitBtn);
        return this;
    }



}
