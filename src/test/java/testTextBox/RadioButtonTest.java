package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.pages.RadioButtonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonTest {

    WebDriver driver;

    RadioButtonPage radioButtonPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        radioButtonPage = new RadioButtonPage();
    }

    @Test
    void clickYesRadioButton(){
        driver.get("https://demoqa.com/radio-button");

        radioButtonPage.clickYesButton();

        String actualYesMessage = driver.findElement(By.xpath("//span[text()='Yes']")).getText();
        Assert.assertEquals(actualYesMessage, "Yes");
    }

    @Test
    void clickImpressiveRadioButton(){
        driver.get("https://demoqa.com/radio-button");

        radioButtonPage
                .clickImpressiveRadioButton();

        String actualImpressiveMessage = driver.findElement(By.xpath("//span[text()='Impressive']")).getText();
        Assert.assertEquals(actualImpressiveMessage, "Impressive");

    }

}
