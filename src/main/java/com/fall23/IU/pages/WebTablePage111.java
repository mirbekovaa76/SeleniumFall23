package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.Employee;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage111 {

    private WebDriver driver;

    public WebTablePage111(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    public WebTablePage111 fillupTheForms111(Employee employee){
//        WebElementHelper webElementHelper = new WebElementHelper();
//        webElementHelper.click(driver.findElement(By.id("addNewRecordButton")))
//                .sendKeys(driver.findElement(By.id("firstName")), employee.getFirstname())
//                .sendKeysWithEnter(driver.findElement(By.id("lastName")), employee.getLastname())
//                .scrollToElement(driver.findElement(By.id("")), )
//
//
//    }
}
