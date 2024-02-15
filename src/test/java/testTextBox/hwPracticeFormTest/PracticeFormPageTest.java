package testTextBox.hwPracticeFormTest;

import com.fall23.IU.data.JavaFaker;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.Student;
import com.fall23.IU.helper.BrowserManager;
import com.fall23.IU.helper.DropDownHelper;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.hwPracticeFormPage.PracticeFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PracticeFormPageTest {

    WebDriver driver;
    PracticeFormPage practiceFormPage;
    BrowserManager browserManager;
    Student student;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        practiceFormPage = new PracticeFormPage();
        browserManager = new BrowserManager(driver);
        browserManager.openByNavigate("https://demoqa.com/automation-practice-form");
    }

    @Test(description = "Fill Up with data")
    void studentFormTest() throws InterruptedException {

        Student randomStudent = JavaFaker.createNewStusentWithFakerData();
        WebElementHelper webElementHelper = new WebElementHelper();
        DropDownHelper dropDownHelper = new DropDownHelper();


        // filling Up first 3 input with faker data
        practiceFormPage.fillUpWithFakerData();


        // select one gender randomly from Gender radioBtn
        practiceFormPage.selectGender();


        // filling Up mobile number input
        practiceFormPage.fillUpMobileNumberWithFakerData();


        // // select date from DatePicker
       practiceFormPage.selectDateMonthYear("18 September 2023");


       // Enter subjects:
        practiceFormPage.selectSubjects();


        // select Hobbies checkbox
        webElementHelper.scrollToElement(practiceFormPage.hobbiesCheckbox.get(0));
        List<WebElement> hobbiesCheckbox = practiceFormPage.hobbiesCheckbox;
        Random randomHobby = new Random();
        int numberOfCheckboxes = randomHobby.nextInt(3)+1;
        Collections.shuffle(hobbiesCheckbox);
        for (int i = 0; i < numberOfCheckboxes; i++){
            webElementHelper.click(hobbiesCheckbox.get(i));
        }

        // Upload picture
        practiceFormPage.uploadFile();
        webElementHelper.scrollToElement(practiceFormPage.submitBtn);

        // filling up Current address input
        webElementHelper
//                .scrollToElement(practiceFormPage.currentAddressInput)
                .sendKeys(practiceFormPage.currentAddressInput, randomStudent.getCurrentAddress());


        // select State and City
        practiceFormPage
                .selectStateAndCity();

        // click Submit button after filling up all fields in the form
        practiceFormPage
                .clickSubmitBtn()
                .clickCloseBtn();


    }


}
