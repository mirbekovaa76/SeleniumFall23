package com.fall23.IU.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeWebDriver {
    // так же как и firefox для edge (по желанию ещё opera browser)
    public static WebDriver loadEdgeDriver(){
        System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // implicitlyWait (неявное ожидание) - 15 секунд будет загружаться страница и html документ
        driver.manage().window().maximize();                               // если в 3 секунду документ еще не загрузился, элемента еще нет, то через цикл и try catch происходит постоянный поиск элемента
        return driver;
    }
}
