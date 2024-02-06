package com.fall23.DEMOQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest { // чтоб каждый раз не прописывать before after classes
    protected WebDriver driver; // protected виден на уровне своего класса и классов Наследников
    protected Actions actions; // Класс для к-л действий (кликов и т.д.)
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.initChromeDriver(); // обращаемся к статик методу класса Manager (чтобы не инициализировать его здесь, DRY)
                                                      // он before class
        actions = new Actions(driver); // передаем driver в параметры для управления браузером

    }

    @AfterClass
    public void tearDown(){ // слезы вниз (часто так называют)
        WebDriverManager.closeWebDriver();
    }

    // Structure:
    // 1. Test class extends BaseTest (protected WebDriver, before class method, after class method)
    // 2. run test class
    // 3. start Before class (from BaseTest -> initChromeDriver())
    // 4. start Test (from Test class (f.e. ByIDTest)
    // 5. start After class (from BaseTest -> closeWebDriver())

}
