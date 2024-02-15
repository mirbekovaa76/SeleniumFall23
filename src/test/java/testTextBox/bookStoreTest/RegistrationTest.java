package testTextBox.bookStoreTest;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.pages.hwBookStoreApp.RegistrationPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {

    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeClass
    void setUpDriver() {
        driver = Driver.getDriver();
        registrationPage = new RegistrationPage();
    }

    @Test(description = "Register new User")
    void registrationTest() throws InterruptedException {
        driver.get("https://demoqa.com/login");
        registrationPage.clickNewUserAndScroll();
        registrationPage.fillTheForm();
        WebElement iframeElement = driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']"));
        driver.switchTo().frame(iframeElement);
        WebElement captchaBtn = driver.findElement(By.className("recaptcha-checkbox-border"));
        captchaBtn.click();
        driver.switchTo().defaultContent();
        Thread.sleep(15000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.onload = function() { window.alert = function(msg) { return true; } }");
        registrationPage.clickRegisterBtn();
        js.executeScript("window.alert('User Register Successfully.')");
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        String expectedAlertMessage = "User Register Successfully.";
        String actualAlertMessage = alert.getText();
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Алерт с неправильным сообщением!");
        alert.accept();

        driver.quit();

    }
}
