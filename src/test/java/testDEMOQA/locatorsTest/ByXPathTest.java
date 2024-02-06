package testDEMOQA.locatorsTest;

import com.fall23.DEMOQA.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.*;

public class ByXPathTest extends BaseTest { // xpath - язык запросов к элементам XML
    // поиск xpath похож на путь
    // В [] - параметры поиска внутри
    // //*[text()='Wikipedia'] -> чтобы найти по названию элемент (* все элементы)
    // //span[text()='Wikipedia'] -> чтобы найти по названию элемент (span - название)
    // //span[contains(text(), 'Wikipedia')] -> найти все элементы, к-е содержат Wikipedia
    // //h3[contains(@class, 'LC20')] -> в теге h3 найти все значения LC20 с атрибутом класс
    // //div[@class='g']

    // //*[@id="rso"]/div[2]/div[1]/div/div/div/div[1]/span/div/div/span/span/svg
    // вот такой поиск тоже не очень, т.к. * ищет везде,
    // лучше указывать div или тег определенный (быстрее поиск)
    // поиск по id, id может изменяться
    // "" лучше заменить на ''


    @Test
    void byXPathTest() throws InterruptedException {
        openTheSite("https://demoqa.com/text-box");

        findElementByXPathAndSendKeys("//*[@id=\"userName\"]", "John");
        findElementByXPathAndSendKeys("//*[@id=\"userEmail\"]", "john@gmail.com");
        findElementByXPathAndSendKeys("//*[@id=\"currentAddress\"]", "Wall Street 555");
        findElementByXPathAndSendKeys("//*[@id=\"permanentAddress\"]", "Sovet 123");
        scrollPage();
        findElementById("submit").click();

        String actual = findElementByXPath("//p[@id='name']").getText();
        String expected = "Name";
        boolean b = expected.contains("Name");
        Assert.assertEquals(actual, b);
        Thread.sleep(5000);
        
    }
}
