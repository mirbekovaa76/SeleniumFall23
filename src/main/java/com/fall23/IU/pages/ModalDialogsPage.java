package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

public class ModalDialogsPage {

    public ModalDialogsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "showSmallModal")
    public WebElement smallModalBtn;

    @FindBy(id = "showLargeModal")
    public WebElement largeModalBtn;

    @FindBy(id = "closeSmallModal")
            public WebElement closeSmallModal;

    @FindBy(id = "closeLargeModal")
            public WebElement closeLargeModal;

    WebElementHelper webElementHelper = new WebElementHelper();
    public ModalDialogsPage clickSmallModal(){
        webElementHelper.click(smallModalBtn);
        return this;
    }

    public ModalDialogsPage clickLargeModal(){
        webElementHelper.click(largeModalBtn);
        return this;
    }

    public ModalDialogsPage clickSmallCloseModal(){
        webElementHelper.click(closeSmallModal);
        return this;
    }

    public  ModalDialogsPage clickLargeCloseModal(){
        webElementHelper.click(closeLargeModal);
        return this;
    }
}
