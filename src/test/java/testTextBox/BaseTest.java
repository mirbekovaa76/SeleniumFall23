package testTextBox;

import com.fall23.DEMOQA.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Actions actions;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.initChromeDriver();
        actions = new Actions(driver);
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.closeWebDriver();
    }

}
