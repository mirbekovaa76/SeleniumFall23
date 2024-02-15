package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.DropDownHelper;
import com.fall23.IU.helper.WebElementHelper;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.Random;

public abstract class BasePage {

    WebDriver driver = Driver.getDriver();
    WebElementHelper webElementHelper = new WebElementHelper();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    DropDownHelper dropDownHelper = new DropDownHelper();
    Faker faker = new Faker();
    Random random = new Random();


    public BasePage(){

        PageFactory.initElements(driver, this);
    }
}
