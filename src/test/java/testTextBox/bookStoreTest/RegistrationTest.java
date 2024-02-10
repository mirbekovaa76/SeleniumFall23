package testTextBox.bookStoreTest;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.pages.hwBookStoreApp.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {

    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        registrationPage = new RegistrationPage();
    }

    @Test(description = "Register new User")
    void registrationTest() throws InterruptedException {
        driver.get("https://demoqa.com/login");

        registrationPage
                .clickNewUserBtn()
                .fillUpTheFirstName("John")
                .fillUpTheLAstName("Doe")
                .fillUpUserName("JohnDoe")
                .fillUpPassword("Johnmmm@132");
        Thread.sleep(10000);
        registrationPage
                .clickOnCaptcha(driver)
                .clickRegisterBtn()
                .clickRegisterBtn();


    }

}
