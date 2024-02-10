package com.fall23.IU.pages.hwBookStoreApp;

import com.fall23.IU.drivers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage {

    public BookStorePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "gotoStore")
    public WebElement goToBookStoreBtn;


}
