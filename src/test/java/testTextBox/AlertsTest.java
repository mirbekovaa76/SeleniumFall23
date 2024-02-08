package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.AlertHelper;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.AlertPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertsTest {

    WebDriver driver;
    AlertPage alertPage;
    AlertHelper alertHelper;


    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        alertPage = new AlertPage();
        alertHelper = new AlertHelper();
    }

    @Test(description = "Click on first 'Click me' button and click accept on alert")
            void clickFirstClickMeBtnAndAcceptAlert(){
        driver.get("https://demoqa.com/alerts");
        alertPage.clickAlertBtn();
        alertHelper.acceptAlert();
    }

    @Test(description = "Click on second 'Click me' button and wait 5 sec until alert appear then click on accept")
    void clickAndWait5SecUntilAlertAppearAndAcceptAlert(){
        driver.get("https://demoqa.com/alerts");
        alertPage.clickTimerAlertBtn();
        alertHelper.acceptAlert();
    }

    @Test(description = "Click on 3 'Click me' button and click accept alert")
    void clickThirdClickButtonAndAcceptAlert(){
        driver.get("https://demoqa.com/alerts");
        alertPage.clickConfirmBtn();
        alertHelper.acceptAlert();
        String actualConfirmMessage = driver.findElement(By.xpath("//span[text()='Ok']")).getText();
        Assert.assertEquals(actualConfirmMessage, "You selected Ok");
    }

    @Test(description = "Click on 'Click me' button and enter yor name on alert then accept alert")
    void enterNameAndAcceptAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        alertPage.clickPromptBtn();
        alertHelper.sendKeysAlert("Aida");
        Thread.sleep(5000);
        alertHelper.acceptAlert();

        String actualEnteredAlertTextMessage = driver.findElement(By.xpath("//span[text()='Aida']")).getText();
        Assert.assertEquals(actualEnteredAlertTextMessage, "You entered Aida");
    }

    @Test(description = "Dismiss alert")
    void dismissAlertTest(){
        driver.get("https://demoqa.com/alerts");
        alertPage.clickConfirmBtn();
        alertHelper.dismissAlert();

        String canceledAlertMessage = driver.findElement(By.xpath("//span[text()='Cancel']")).getText();
        Assert.assertEquals(canceledAlertMessage, "You selected Cancel");
    }


    // Test wrote in Class with Nuta
//    @Test
//    void confirmAlertTest() throws InterruptedException {
//
//        WebDriver driver = Driver.getDriver();
//        driver.get("https://demoqa.com/alerts");
//        WebElement confirmBtn = driver.findElement(By.id("confirmButton"));
//        confirmBtn.click();
//
//        AlertHelper alertHelper = new AlertHelper();
//        alertHelper.acceptAlert();
//
//        String actualConfirmMessage = driver.findElement(By.xpath("//span[text()='Ok']")).getText();
//        Assert.assertEquals(actualConfirmMessage, "You selected Ok");


}
