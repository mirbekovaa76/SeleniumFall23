package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CaptchaTest {

    WebDriver driver;

    @Test
    void demo1233() throws InterruptedException {
        driver = Driver.getDriver();

        driver.get("https://demoqa.com/register");
        WebElementHelper webElementHelper = new WebElementHelper();

        WebElement recaptcha = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(recaptcha);
        webElementHelper.scrollToElement(recaptcha);

        WebElement recaptchClick = driver.findElement(By.id("recaptcha-anchor-label"));
        recaptchClick.click();
        Thread.sleep(5000);

    }

}
