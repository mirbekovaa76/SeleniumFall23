package com.fall23.IU.helper;

import org.openqa.selenium.WebDriver;

public class BrowserManager {

    private WebDriver driver;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
    }

    public void openByNavigate(final String URL){
        driver.navigate().to(URL);      // navigate to --> сохраняет историю , запоминает страницы
                                        // и можем управлять кнопками Назад Вперед
    }

    public void openByGet(final String URL){
        driver.get(URL);                // get --> не сохраняет историю страницы
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void goForward(){
        driver.navigate().forward();
    }

    public void refreshThePage(){
        driver.navigate().refresh();
    }

    // TODO move all methods like: Frame, Window

    // Frame methods:

}
