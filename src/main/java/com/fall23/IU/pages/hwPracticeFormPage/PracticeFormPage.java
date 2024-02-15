package com.fall23.IU.pages.hwPracticeFormPage;

import com.fall23.IU.data.JavaFaker;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.Student;
import com.fall23.IU.helper.DropDownHelper;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.*;

public class PracticeFormPage{

    WebDriver driver = Driver.getDriver();
    WebElementHelper webElementHelper = new WebElementHelper();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    DropDownHelper dropDownHelper = new DropDownHelper();
    Faker faker = new Faker();
    Random random = new Random();


    public PracticeFormPage(){
        PageFactory.initElements(driver, this);
    }

    Student randomStudent = JavaFaker.createNewStusentWithFakerData();
    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(xpath = "//div[@class='custom-control custom-radio custom-control-inline']")
    public List<WebElement> genderRadioBtn;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberInput;

    @FindBy(xpath = "//div[@class='react-datepicker__input-container']")
    public WebElement datePickerBtn;

//    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
//    public WebElement monthSelect;
//
//    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
//    public WebElement yearSelect;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//div[@class='custom-control custom-checkbox custom-control-inline']")
    public List <WebElement> hobbiesCheckbox;

    @FindBy(id = "uploadPicture")
    public WebElement chooseFileBtn;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement selectState;

    @FindBy(id = "react-select-4-input")
    public WebElement selectCity;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitBtn;

    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeModalBtn;


    // filling Up first 3 input with faker data
    public PracticeFormPage fillUpWithFakerData(){
        webElementHelper
                .sendKeys(firstNameInput, randomStudent.getFirstname())
                .sendKeys(lastNameInput, randomStudent.getLastname())
                .sendKeys(emailInput, randomStudent.getEmail());
        return this;
    }

    // select one gender randomly from Gender radioBtn
    public PracticeFormPage selectGender(){
        List<WebElement> genderRBtn = genderRadioBtn;
        Random randomGender = new Random();
        int randomNumber = randomGender.nextInt(3);    // nextInt - любое число до указ.числа (не включая указанное)
        webElementHelper.click(genderRBtn.get(randomNumber));
        return this;
    }

    // filling Up mobile number input
    public PracticeFormPage fillUpMobileNumberWithFakerData(){
        webElementHelper
                .sendKeys(mobileNumberInput, randomStudent.getMobileNumber());
        // TODO KG +996 (length) Operators 0! MEGA BEELINE
        return this;
    }

    // select date randomly from Date picker
//    public PracticeFormPage selectRandomDateOfBirth(){
//        int minYear = 1900;
//        int maxYear = 2101;
//        int randomYear = faker.random().nextInt(minYear, maxYear); // exclusive last value 2100
//        // SompleDateFormat day1 = new SimpleDateFormat("dd MMMM y", Locale.ENGLISH).format(birthday);
//        LocalDate birthday = LocalDate.of(randomYear, 1,1).plusDays(faker.random().nextInt(366)); // exclusive last value 366
//
//        String ddMMMMy = DateTimeFormatter.ofPattern()
//    }

    // select date from DatePicker
    public PracticeFormPage selectDateMonthYear(String dateMonthYear){
        // поделить строку на 3 части через метод сплит
        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        webElementHelper.click(datePickerBtn);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker__month-select")
        ));

        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker__year-select")));

        DropDownHelper dropDownHelper = new DropDownHelper();

        // select month
        dropDownHelper.selectByText(monthDropDown, month)

                // select year
                .selectByText(yearDropDown, year);

        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//div[contains(@class,'react-datepicker__day') and not(contains(" +
                                "@class, 'react-datepicker__day--outside-month')) and text()='" + day + "']")));
        webElementHelper.click(dayElement);
        return this;
    }

    // Enter subjects
    public PracticeFormPage selectSubjects(){
        List<String> subjectsList = Arrays.asList("Eng", "Ma", "Soc", "Acc", "Ph", "Com", "Che", "Sci", "Hi");
        for (int i = 0; i < 5; i++){
            int randomIndex = faker.random().nextInt(subjectsList.size());
            String subject = subjectsList.get(randomIndex);
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(Keys.TAB);
        }
        return this;
    }

    // select hobbies from Hobbies checkbox
    public PracticeFormPage selectRandomlyHobbiesFromCheckbox(){
        webElementHelper.scrollToElement(hobbiesCheckbox.get(0));
        List<WebElement> listOfHobbies = hobbiesCheckbox;
        Random randomHobby = new Random();

        return this;
    }

    // upload random picture
    public PracticeFormPage uploadFile(){
        String directoryPath = "C:\\Users\\User\\Desktop\\pictures\\";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        File randomFile = files[random.nextInt(files.length)];
        String absolutePath = randomFile.getAbsolutePath();
        chooseFileBtn.sendKeys(absolutePath);
        return this;
    }

    // select state and city
    public PracticeFormPage selectStateAndCity(){
        Map<String, List<String>> stateCityMapping = new HashMap<>();
        stateCityMapping.put("N", Arrays.asList("De", "Gu", "No"));
        stateCityMapping.put("U", Arrays.asList("A", "Lu", "Me"));
        stateCityMapping.put("Har", Arrays.asList("K", "P"));
        stateCityMapping.put("Raja", Arrays.asList("Jai", "Jaise"));
        List<String> states = Arrays.asList("N", "U", "Har", "Raja");

        int randomIndex = faker.random().nextInt(states.size());
        String state = states.get(randomIndex);

        List<String> cities = stateCityMapping.get(state);

        String city = cities.get(faker.random().nextInt(cities.size()));

        selectState.sendKeys(state);
        selectState.sendKeys(Keys.TAB);

        selectCity.sendKeys(city);
        selectCity.sendKeys(Keys.TAB);
        return this;
    }

    // click submit button
    public PracticeFormPage clickSubmitBtn() throws InterruptedException {
        submitBtn.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        return this;
    }

    // click close modal
    public PracticeFormPage clickCloseBtn() throws InterruptedException {
        webElementHelper.scrollToElement(closeLargeModalBtn);
        closeLargeModalBtn.sendKeys(Keys.ESCAPE);
        Thread.sleep(5000);
        return this;
    }



}
