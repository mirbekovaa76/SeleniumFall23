package testTextBox.bookStoreTest;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.hwBookStoreApp.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        loginPage = new LoginPage();
    }

    @Test(description = "Login with Valid Username and Password")
    void positiveLoginTest(){
        driver.get("https://demoqa.com/login");
        loginPage
                .fillUpUserNameInput("test")
                .fillUpPassword("!!Testtest2024")
                .clickLoginBtn();
    }

    @Test(description = "Login with Invalid data", dataProvider = "provider")
    void negativeLoginTest(String username, String password){
        driver.get("https://demoqa.com/login");
        loginPage
                .fillUpUserNameInput(username)
                .fillUpPassword(password)
                .clickLoginBtn();

        String actualInvalidLoginMessage = driver.findElement(By.xpath("//p[text()='Invalid username or password!']")).getText();
        Assert.assertEquals(actualInvalidLoginMessage, "Invalid username or password!");

    }


    @DataProvider(name = "provider")
    public Object[][] getInvalidData(){
        return new Object[][]{
                {"test", "123test"},
                {"testtest", "!!Testtest2024"}
        };
    }

    @Test(description = "Logout from BookStorePage")
    void logoutTest() throws InterruptedException {
        driver.get("https://demoqa.com/login");
        loginPage
                .fillUpUserNameInput("test")
                .fillUpPassword("!!Testtest2024")
                .clickLoginBtn();
                Thread.sleep(5000);
                loginPage
                        .clickLogoutBtn();
    }
}
