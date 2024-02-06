package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.pages.CheckBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CheckBoxTest {

    WebDriver driver;

    CheckBoxPage checkBoxPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        checkBoxPage = new CheckBoxPage();
    }

    @Test
    void clickAllBtns() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");
        checkBoxPage.clickHomeBtn()
                .clickDesktopBtn()
                .clickDocumentsBtn()
                .clickDownloadsBtn()
                .clickAndSelectAllDesktopFiles()
                .clickAndSelectAllDocumentsFiles()
                .clickAndSelectAllDownloadsFiles();

        String actualHomeFullCheckIcon = driver.findElement(By.xpath("(//*[name()='svg' and contains(@class, 'icon-check')])[1]")).getText();
        assertFalse(actualHomeFullCheckIcon.contains("half-check"));

    }
}
