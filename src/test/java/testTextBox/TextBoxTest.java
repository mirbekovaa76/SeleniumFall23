package testTextBox;

import com.fall23.IU.config.ConfigReader;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.AlertHelper;
import com.fall23.IU.helper.FrameHelper;
import com.fall23.IU.helper.WindowHandler;
import com.fall23.IU.pages.TextBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxTest {
    WebDriver driver;
    TextBoxPage textBoxPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        textBoxPage = new TextBoxPage();
    }

    @Test
    void fillUpTheFormPositiveTest(){
        driver.get("https://demoqa.com/text-box");
        textBoxPage
                .fillUpFullName("John Doe")
                .fillUpEmail("john@gmail.com")
                .fillUpCurrentAdress("Mira 123")
                .fillUpPermanentAdress("Sovet 321")
                .clickSubmitBtn();

        // homework
        // add the assertions:
        // Assert.assertEquals();

        String actualFullName = driver.findElement(By.cssSelector("p[id='name']")).getText();
        Assert.assertEquals(actualFullName, "Name:John Doe");

        String actualEmail = driver.findElement(By.cssSelector("p[id='email']")).getText();
        Assert.assertEquals(actualEmail, "Email:john@gmail.com");

        String actualCurrentAddress = driver.findElement(By.cssSelector("p[id='currentAddress']")).getText();
        Assert.assertEquals(actualCurrentAddress, "Current Address :Mira 123");

        String actualPermanentAddress = driver.findElement(By.cssSelector("p[id='permanentAddress']")).getText();
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :Sovet 321");

    }

    @Test
    void switchAndClosingTabs() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tabButton"));
        for (int i = 0; i < 6; i++) {
            newTab.click();
            Thread.sleep(1500);
        }
        WindowHandler windowHandler = new WindowHandler();
        windowHandler.switchToParentWithChildClose();

    }


    @Test
    void alertTest() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/alerts");
        WebElement confirmBtn = driver.findElement(By.id("confirmButton"));
        confirmBtn.click();

        AlertHelper alertHelper = new AlertHelper();
        alertHelper.acceptAlert();

    }

    @Test
    void frameTest(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        FrameHelper frameHelper = new FrameHelper(driver);
        WebElement frameID = driver.findElement(By.id("frame1"));
        frameHelper.swithcToFrame(frameID);

        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    }
}
