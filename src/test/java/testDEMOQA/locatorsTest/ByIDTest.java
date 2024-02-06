package testDEMOQA.locatorsTest;

import com.fall23.DEMOQA.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite; // импорт статик метода через класс (в классе тогда не обязательно вызывать класс)

public class ByIDTest extends BaseTest { // будем искать по локатору id
    // не лучший вариант, т.к. id генерятся на сервере динамически и если появляется новый элемент на странице, то id меняется и нужно изменить в коде id

    @Test
    void byIdTest() throws InterruptedException {
        openTheSite("https://demoqa.com/text-box");

        WebElement userNameInput = driver.findElement(By.id("userName")); // id - уникальный, поэтому ищем по атрибуту id
        WebElement userEmailInput = driver.findElement(By.id("userEmail"));
        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        WebElement submitBtn = driver.findElement(By.id("submit")); // button submit

        //заполнение форм: (можно сразу в webelement
        userNameInput.sendKeys("John");
        userEmailInput.sendKeys("john@gmail.com");
        currentAddressInput.sendKeys("Wall Street 555");
        permanentAddressInput.sendKeys("Sovet 123");

        // чтобы пролистать вниз страницу:
        JavascriptExecutor js = (JavascriptExecutor) driver; // интерфейс JavascriptExecutor
        js.executeScript("window.scrollBy(0, 300)"); // 0 вверх, 600 - низ
        submitBtn.click();
        Thread.sleep(5000);
    }


}
