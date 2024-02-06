package testDEMOQA.locatorsTest;

import com.fall23.DEMOQA.BaseTest;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementByXPath;

public class ByXpathDemo extends BaseTest { // xpath - это путь по сути
    // basic locators: id, name, link text, partial link test, class name
    // advanced locators: xpath, css selector

    // Виды Xpath:
    // 1. Absolute xpath(/html/body/div...) -> в 90% не используются, т.к. путь может измениться (если добавить новый элемент)
    // 2. Relative xpath -> начинаем с конкретного тега -> //input[@placeholder='name@example.com'] (в @ конкретный атрибут = и '' название)
    // (//label[@for='access-offer'])[1] -> чтоб выбрать 1 можно взять в () и [1] нумерацию какой именно
    // //input[@id='access-offer']/../label -> /.. обращаться назад
    // (//input[@id='access-offer']/following-sibling::label)[1] -> following sibling -> обращаться к соседним тегам, принадлежащие к 1 родителю
    // //*[@id='somename'] -> искать везде

    @Test
    void demo() throws InterruptedException {
        openTheSite("https://demoqa.com/text-box");

        findElementByXPath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input").sendKeys("John Doe");
        Thread.sleep(5000);
    }
}
