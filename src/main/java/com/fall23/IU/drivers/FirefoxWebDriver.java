package com.fall23.IU.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxWebDriver {

    // Create method to load firefox web driver
    // метод который б.д загружать firefox браузер

    public static WebDriver loadFirefoxDriver(){
        System.setProperty("webdriver.firefox.driver", "src/main/resources/Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // implicitlyWait (неявное ожидание) - 15 секунд будет загружаться страница и html документ
        driver.manage().window().maximize();                               // если в 3 секунду документ еще не загрузился, элемента еще нет, то через цикл и try catch происходит постоянный поиск элемента
        return driver;
    }
}
