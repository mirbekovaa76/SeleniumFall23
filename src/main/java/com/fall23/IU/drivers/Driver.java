package com.fall23.IU.drivers;

import com.fall23.IU.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver { // для управления драйверами
    private Driver(){
        // singleton pattern
    }
    private static WebDriver driver;

    // метод для запуска браузера в зависимости от свойств
    public static WebDriver getDriver(){
        if (driver == null){
            switch (ConfigReader.getValue("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver(); // если browser = chrome, то запускаем метод loadChromeDriver
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        }

        return driver;
    }

    // метод для закрытия драйвера
    public static void closeDriver(){
        try {
            if (driver!=null){
                driver.close(); // закрыли
                driver.quit(); // вышли с сессии
                driver=null; // присвоили null, чтобы в след раз getDriver() был null и if сработал
            }
        }catch (Exception e){
            System.out.println("Error while closing driver");
        }
    }

}
