package com.fall23.DEMOQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverManager { // класс для инициализации и управления веб драйвером (чтобы не повторять код -> DRY - Don't repeat yourself)

    public static WebDriver driver;

    public static WebDriver initChromeDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // implicitlyWait (неявное ожидание) - 15 секунд будет загружаться страница и html документ
        driver.manage().window().maximize();                               // если в 3 секунду документ еще не загрузился, элемента еще нет, то через цикл и try catch происходит постоянный поиск элемента
        return driver;                                                     // если нашел, то уже делает действия
                                                                           // если спустя 15 секунд не нашел, то NoSuchElementException - нет такого элемента
                                                                           // implicitlyWait -> неявное, ждет загрузку страницы, html документа
                                                                           // explicitWait -> явное ожидание, когда документ полностью загружен, но некоторе элементы появляются только через определенное время
                                                                           // например, как страница загружена кнопка появляется через 5 секунд https://demoqa.com/dynamic-properties
                                                                           // или когда реклама на всю страницу появляется
                                                                           // т.е. жди пока эта кнопка/id/class не появится
                                                                           // это всё явное ожидание

    }


    public static void closeWebDriver(){
        driver.close();
        driver.quit();
    }
    public static void openTheSite(String URL){ // для открытия сайтов (только url указать)
        driver.get(URL);
    }
}
