package testDEMOQA.MouseInteractions;

import com.fall23.DEMOQA.BaseTest;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementById;
import static com.fall23.DEMOQA.WebElementManager.findElementByXPath;
import static org.testng.Assert.assertEquals;

public class AdvancedMouseInteractions extends BaseTest {


    @Test
    void rightClickTest() throws InterruptedException {
        openTheSite("https://demoqa.com/buttons");
        // findElementById("rightClickBtn");
        // WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(findElementById("rightClickBtn")).perform();
        String actualContextClickMessage = findElementById("rightClickMessage").getText();
        // driver.findElement(By.id("rightClickMessage")).getText();
        assertEquals(actualContextClickMessage,"You have done a right click");
    }

    @Test
    void doubleClickTest() throws InterruptedException {
        openTheSite("https://demoqa.com/buttons");
        actions.doubleClick(findElementById("doubleClickBtn")).perform(); // perform - выполнить действие/команду
        String actualDoubleClickMessage = findElementById("doubleClickMessage").getText();
        assertEquals(actualDoubleClickMessage, "You have done a double click");
    }


    @Test
    void dynamicClickTest() throws InterruptedException {
        openTheSite("https://demoqa.com/buttons");
        actions.click(findElementByXPath("//button[text()='Click Me']")).perform();
        String actualDynamicClickMessage = findElementById("dynamicClickMessage").getText();
        assertEquals(actualDynamicClickMessage,"You have done a dynamic click");
    }



}
