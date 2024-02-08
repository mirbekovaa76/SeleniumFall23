package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.pages.ButtonsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsTest {

    WebDriver driver;
    ButtonsPage buttonsPage;
    Actions actions;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        buttonsPage = new ButtonsPage();
    }

    @Test
    void clickAllBtns() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        buttonsPage.clickDoubleBtn();
        buttonsPage.clickRightBtn();
        buttonsPage.clickMeBtn();

        String actualDoubleClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals(actualDoubleClickMessage, "You have done a double click");

        String actualRightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals(actualRightClickMessage, "You have done a right click");

        String actualDynamicClickMessage = driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals(actualDynamicClickMessage, "You have done a dynamic click");

    }

}
