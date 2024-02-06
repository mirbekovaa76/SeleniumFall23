package testDEMOQA.locatorsTest;

import com.fall23.DEMOQA.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.*;

public class ByClassNameTest extends BaseTest { // ищем элементы по имени класса (уникальный должен быть, ищем без пробелов) (можно посмореть в консоли в поиске через ctrl f)

    @Test
    void byClassNameTest() throws InterruptedException {
        openTheSite("https://demoqa.com/text-box");

        findElementByIdAndSendKeys("userName", "John");
        findElementByIdAndSendKeys("userEmail", "john@gmail.com");
        findElementByIdAndSendKeys("currentAddress", "Wall Street 555");
        findElementByIdAndSendKeys("permanentAddress", "Sovet 123");
        scrollPage();


        findElementByClassName("btn-primary").click(); // без пробелов (был: btn btn-primary) или с точкой (btn.btn-primary)

        String actualTable = findElementByCssSelector("p[class='mb-1']").getText();
        String expectedTable = "p[class='mb-1']";
        Assert.assertEquals(actualTable, expectedTable);
        System.out.println("U a here");
        // Thread.sleep(5000);
    }
}
