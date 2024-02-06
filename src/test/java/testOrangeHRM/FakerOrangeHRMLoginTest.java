package testOrangeHRM;

import com.fall23.OrangeHRM.User;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FakerOrangeHRMLoginTest {
    User user = new User();
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void generateData(){
        Faker fakeData = new Faker();
        user.setUsername(fakeData.name().username());
        user.setPassword(fakeData.internet().password());
    }
    @BeforeClass
    void openSite(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String actualLoginText = driver.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);
    }
    @Test(description = "Login with invalid data")
    void loginWithInvalidDataTest() throws Exception{

        WebElement usernameInputField = driver.findElement(By.name("username"));
        WebElement passwordInputField = driver.findElement(By.name("password"));

        usernameInputField.sendKeys(user.getUsername());
        passwordInputField.sendKeys(user.getPassword());

        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualFailedLogin = driver.findElement(By.tagName("p")).getText();
        String expectedFailedLogin = "Invalid credentials";
        Assert.assertEquals(actualFailedLogin, expectedFailedLogin);
        Thread.sleep(5000);
    }

}
