package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectMenuPage {

    public SelectMenuPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "oldSelectMenu")
    public WebElement olldStyleSelectMenu;

    @FindBy(id = "react-select-3-input")
    public WebElement selectValueInput;

}
