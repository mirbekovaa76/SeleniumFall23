package testDEMOQA.locatorsTest;

import com.fall23.DEMOQA.BaseTest;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementByLinkTextAndClick;

public class ByLinkedTextTest extends BaseTest { // поиск по ссылке
    // link text and partial link text - дольще ищут, т.к много действий под их капотом (если можно использовать другой спосок, то лучше его, а не поиск по линку)

    @Test
    void test123() throws InterruptedException {
        openTheSite("https://demoqa.com/links");

        findElementByLinkTextAndClick("Home");
        // findElementByLinkText("Home").click(); // // нашел по названию этой ссылки


        Thread.sleep(5000);
    }
}
