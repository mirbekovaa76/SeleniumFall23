package testDEMOQA.locatorsTest;

import com.fall23.DEMOQA.BaseTest;
import com.fall23.OrangeHRM.User;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.*;

public class FakerByIDTest extends BaseTest {
    User user = new User();

    @BeforeTest
    public void generateData(){
        Faker fakeData = new Faker();
        user.setUsername(fakeData.name().username());
        user.setEmail(fakeData.internet().emailAddress());
        user.setCurrentAddress(fakeData.address().streetAddress());
        user.setPermanentAddress(fakeData.address().streetAddressNumber());
    }

    @Test
    void FakerByIdTest() throws InterruptedException {
        openTheSite("https://demoqa.com/text-box");

        // findElementById("userName").sendKeys(user.getUsername());
        findElementByIdAndSendKeys("userName", user.getUsername());
        findElementByIdAndSendKeys("userEmail", user.getEmail());
        findElementByIdAndSendKeys("currentAddress", user.getCurrentAddress());
        findElementByIdAndSendKeys("permanentAddress", user.getPermanentAddress());
        scrollPage();
        findElementById("submit").click();

//        String actualTable = findElementByXPath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]").getText();
//        String expectedTable = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]";
//
//        Assert.assertEquals(actualTable, expectedTable);
        Thread.sleep(5000);
    }
}
