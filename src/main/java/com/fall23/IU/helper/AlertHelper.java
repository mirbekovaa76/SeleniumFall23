package com.fall23.IU.helper;

import com.fall23.IU.drivers.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {


    // метод для управления(переключения) браузера с html на алерт
    public Alert getAlert() {
        return Driver.getDriver().switchTo().alert();
    }

    // для клика на кнопку accept (будь другая кнопка, то подстраиваем этот метод под нее)
    public void acceptAlert() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        if (!isAlertPresent()){
            return;
        }
        getAlert().accept();

    }

    // для клика на кнопку отмены в алерте
    public void dismissAlert() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.alertIsPresent());
        if (!isAlertPresent()){
            return;             // если алерта нету то остановись(return)
        }
        getAlert().dismiss();
    }

    public void sendKeysAlert(String txt) {
        if (!isAlertPresent()){
            return;
        }
        getAlert().sendKeys(txt);
    }

    public boolean isAlertPresent(){
        try {
            Driver.getDriver().switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }
}
