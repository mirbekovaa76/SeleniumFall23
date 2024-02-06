package testTextBox;

import com.fall23.IU.config.ConfigReader;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.pages.TextBoxPage;
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
                .fillUpEmail("sdsd@gmail.com")
                .fillUpCurrentAdress("Mira 123")
                .fillUpPermanentAdress("Sovet 321")
                .clickSubmitBtn();
        // homework
        // add the assertions:
        // Assert.assertEquals();
    }
}
