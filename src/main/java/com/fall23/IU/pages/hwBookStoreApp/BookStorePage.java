package com.fall23.IU.pages.hwBookStoreApp;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Book;

public class BookStorePage {

    public BookStorePage(){

        PageFactory.initElements(
                Driver.getDriver(), this);
    }

    @FindBy(id = "gotoStore")
    public WebElement goToBookStoreBtn;

    @FindBy(xpath = "//span[@id='see-book-Learning JavaScript Design Patterns']")
    public WebElement clickJavaLearningBook;

    @FindBy(xpath = "(//button[@id='addNewRecordButton'])[2]")
    public WebElement addToYourCollectionBtn;

    WebElementHelper webElementHelper = new WebElementHelper();

    public BookStorePage clickGoToStoreBtn(){
        webElementHelper.click(goToBookStoreBtn);
        return this;
    }

    public BookStorePage clickOnJavaLearningBook(){
        webElementHelper.click(clickJavaLearningBook);
        return this;
    }

    public BookStorePage clickAddToCollectionBtn(){
        webElementHelper.click(addToYourCollectionBtn);
        return this;
    }


}
