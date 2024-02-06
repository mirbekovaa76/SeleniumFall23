package com.fall23.IU.helper;

import com.fall23.IU.drivers.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.fall23.DEMOQA.WebDriverManager.driver;

// 2 шаблон проектирования - Chain of invocations (цепочка вызовов)
public class WebElementHelper { // помощник (как webDriverManager чтобы универсально работало всё
    // настраиваем под себя методы WebElement (улучшаем под себя и т.д.)
    // делаем так всегда (т.к. просто WebElement тесты могут проходить, а могут и нет)


    // для ожидания элемента
    public WebElementHelper waitForButtonToBeClickAble(WebElement element){ // return type сам же класс (для метод chaining)
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7)) // указываем метод, чтобы передавать разные драйвера (в зависимости от properties)
                .until(ExpectedConditions.elementToBeClickable(element));
        return this; // вернуть текущий класс WebElementHelper
    }

    // ждать пока элемент не покажется
    public WebElementHelper waitForElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
        return this;                                                         // жди 15 секунд пока элемент не появится
    }

    // для клика элемента
    public WebElementHelper click(WebElement element){
        waitForButtonToBeClickAble(element);
        element.click(); // этот click принадлежит классу WebElementHelper
        // по сути свой click и WebElement click() - отличаются ожиданием, благодаря методу waitForButtonToBeClickAble()
        // улучшили метод под себя
        return this;
    }

    // для input, ввода данных
    public WebElementHelper sendKeys(WebElement element, String input){
        waitForButtonToBeClickAble(element);
        element.sendKeys(input);
        return this;
    }

    // для скролла страницы
    public WebElementHelper scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element); // будет скроллить до самого элемента (в середине был чтоб или сверху?)
        return this;
    }


}
