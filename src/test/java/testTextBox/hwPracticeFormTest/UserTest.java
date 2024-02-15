package testTextBox.hwPracticeFormTest;

import com.fall23.IU.data.JavaFaker;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.Student;
import com.fall23.IU.entity.User;
import com.fall23.IU.helper.BrowserManager;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.hwPracticeFormPage.UsersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {

    WebDriver driver;
    UsersPage usersPage;
    User user;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        usersPage = new UsersPage();
    }

    @Test(description = "Sign in to browser and choose the certificate field")
    void openBrowserAndLogIn() throws InterruptedException {
        BrowserManager browserManager=new BrowserManager(Driver.getDriver());
        browserManager.openByNavigate("https://app.talentlms.com/login");
        driver.findElement(By.xpath("(//input[@name='domain'])[1]")).sendKeys("aizirekfall23");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Aizirek98");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("7878@Aizi");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        driver.findElement(By.xpath("//b[text()='Administrator dashboard']")).click();
        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("a[href='https://aizirekfall23.talentlms.com/account/certifications_index']")).click();

//        driver.findElement(By.xpath("(//input[@name='domain'])[1]")).sendKeys("aizirekfall23");
//        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Aizirek98");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("7878@Aizi");
//
//        driver.findElement(By.xpath("(//input[@name='domain'])[1]")).sendKeys("fall2023selenium");
//        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Bema2000");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Bema@2000");

        WebElementHelper webElementHelper = new WebElementHelper();

        webElementHelper.click(usersPage.homeAddUserBtn);

        usersPage
                .fillUpUserWithFakerData()
                .selectUserType()
                .selectTimeZone()
                .selectLanguage()
                .clickOnExcludefromEmailsCheckbox()
                .clickOnAddUserSubmitBtn();

        String actualAddUserMessage = usersPage.addUserSuccessMessage.getText();
        Assert.assertEquals(actualAddUserMessage, "Success! Do you want to add another user?");

    }

    }
