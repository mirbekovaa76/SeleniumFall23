package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.BrowserManager;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.PracticeFormPageSelectDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class PracticeFormTest {

    WebDriver driver;
    @Test
    void demo123(){
        driver = Driver.getDriver();
        BrowserManager browserManager = new BrowserManager(Driver.getDriver());
        browserManager.openByNavigate("https://demoqa.com/automation-practice-form");
        PracticeFormPageSelectDate practiceFormPage = new PracticeFormPageSelectDate();
        practiceFormPage.selectDateMonthYear("5 March 2015");

        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']"));
        Random randomRadioBtn = new Random();
        int randomNumber = randomRadioBtn.nextInt(3);
        WebElementHelper webElementHelper = new WebElementHelper();
        webElementHelper.click(radioButtons.get(randomNumber));


    }
}
