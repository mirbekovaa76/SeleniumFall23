package testDEMOQA.Waits;

import com.fall23.DEMOQA.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementById;

public class ExplicitWait extends BaseTest {

    @Test
    void waitForElementToBeClickAble(){
        openTheSite("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7)); // создаем объект, передаем драйвер и с запасом указали на 2 секунды больше
        wait.until(ExpectedConditions.elementToBeClickable(findElementById("enableAfter"))).click(); // жди пока элемент с таким id "enableAfter" не будет кликабельным (elementToBeClickable) и кликни

        wait.until(ExpectedConditions.visibilityOf(findElementById("visibleAfter"))).click(); // жди пока элемент с таким id "visibleAfter" не появится и кликни

        WebElement dangerColor = driver.findElement(By.id("colorChange")); // создал WebElement чтобы в sout посмотреть результат ч-з getAttribute

        wait.until(ExpectedConditions.attributeContains(dangerColor, "class", "danger"));

        System.out.println(dangerColor.getAttribute("class")); // просто показать значение атрибута класс (чтобы посмотреть измения)
        // до 5 секунд явного ожидания (после загрузки html документа): mt-4 btn btn-primary
        // после 5 секунд явного ожидания (после загрузки html документа): mt-4 text-danger btn btn-primary
    }
}
