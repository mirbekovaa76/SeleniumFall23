package testDEMOQA.locatorsTest;

import com.fall23.DEMOQA.BaseTest;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementByPartialLinkTextAndClick;

public class ByPartialLinkTextTest extends BaseTest { // искать по совпадению названия (часть названия, part of the word)

    @Test
    void test123() throws InterruptedException {
        openTheSite("https://demoqa.com/links");

        findElementByPartialLinkTextAndClick("Unaut");

        Thread.sleep(5000);
    }


}
