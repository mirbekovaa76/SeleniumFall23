package testDEMOQA;

import com.fall23.DEMOQA.BaseTest;
import org.testng.annotations.Test;
import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementById;
import static com.fall23.DEMOQA.WebElementManager.findElementByXPath;
import static org.testng.Assert.*;

public class RadioButtonTest extends BaseTest {

    @Test(description = "Open site and click on Yes btn")
    void YesBtnClickTest(){
        openTheSite("https://demoqa.com/radio-button");
        actions.click(findElementById("yesRadio")).perform();
        String actualYesMessage = findElementByXPath("//span[text()='Yes']").getText();
        assertEquals(actualYesMessage, "Yes");
    }
    @Test(description = "On the site click Impressive btn", dependsOnMethods = {"YesBtnClickTest"})
    void ImpressiveBtnClickTest() {
        actions.click(findElementById("impressiveRadio")).perform();
        String actualImpressiveMessage = findElementByXPath("//span[text()='Impressive']").getText();
        assertEquals(actualImpressiveMessage, "Impressive");
    }
}
