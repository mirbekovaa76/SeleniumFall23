package com.fall23.IU.pages.hwPracticeFormPage;

import com.fall23.IU.data.JavaFaker;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.User;
import com.fall23.IU.helper.DropDownHelper;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.hwBookStoreApp.RegistrationPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class UsersPage {

    WebDriver driver = Driver.getDriver();
    WebElementHelper webElementHelper = new WebElementHelper();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    DropDownHelper dropDownHelper = new DropDownHelper();
    Faker faker = new Faker();
    Random random = new Random();

    User randomUser = JavaFaker.createNewUserWithFakerData();

    public UsersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "(//div[@class='tl-bold-link']/child::a)[1]")
//    public WebElement homeUsersBtn;

//    @FindBy(xpath = "(//a[@class='btn btn-primary'])[3]")
//    public WebElement usersBtn;

    // for Add user
    @FindBy(xpath = "(//div[@class='hidden-phone']/child::a)[1]")
    public WebElement homeAddUserBtn;

    @FindBy(xpath = "(//a[@class='btn btn-primary'])[3]")
    public WebElement addUserBtn;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstnameInput;

    @FindBy(xpath = "//input[@name='surname']")
    public WebElement lastnameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement bioInput;

    @FindBy(xpath="(//span[@class='select2-arrow'])[1]")
    public WebElement userTypesSelectBtn;

    @FindBy(xpath = "(//span[@class='select2-chosen'])[2]")
    public WebElement timeZoneSelectBtn;

    @FindBy(xpath = "//span[contains(text(),'English')]")
    public WebElement languageSelectInput;

    @FindBy(xpath = "//input[@id='status']")
    public WebElement activeCheckbox;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement deActivateAtCheckbox;;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement excludeFromEmailsCheckbox;

    @FindBy(xpath = "//input[@name='submit_personal_details']")    // //input[@name=\"submit_personal_details\"]
    public WebElement addUserSubmitBtn;

    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelAddUserSubmitBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement addUserSuccessMessage;


    // fillUp first 6 inputs with Faker data
    public UsersPage fillUpUserWithFakerData(){
        webElementHelper
                .sendKeys(firstnameInput, randomUser.getFirstname())
                .sendKeys(lastnameInput, randomUser.getLastname())
                .sendKeys(emailInput, randomUser.getEmailAddress())
                .sendKeys(usernameInput, randomUser.getUsername());
        passwordInput.sendKeys("TestTest123!");
//                .sendKeys(passwordInput, randomUser.getPassword())
        webElementHelper
                .sendKeys(bioInput, randomUser.getBio());
        return this;
    }

    // select certain User type
    public UsersPage selectUserType() throws InterruptedException {
        Thread.sleep(3000);
        webElementHelper.click(userTypesSelectBtn);
        List<WebElement> userTypeDropdown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = new Random().nextInt(userTypeDropdown.size());
        userTypeDropdown.get(randomIndex).click();
        return this;
    }

    public UsersPage selectTimeZone() throws InterruptedException {
        webElementHelper.click(timeZoneSelectBtn);
        Thread.sleep(3000);
        List<WebElement> timeZoneDropdown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = new Random().nextInt(timeZoneDropdown.size());
        timeZoneDropdown.get(randomIndex).click();
        Thread.sleep(3000);
        return this;
    }

    public UsersPage selectLanguage(){
        webElementHelper.click(languageSelectInput);
        List<WebElement> languageDropdown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = new Random().nextInt(languageDropdown.size());
        webElementHelper.waitForButtonToBeClickAble(languageSelectInput);
        languageDropdown.get(randomIndex).click();
        webElementHelper.scrollToElement(addUserSubmitBtn);
        return this;
    }

    public UsersPage clickOnDeActivateCheckbox(){
        webElementHelper.scrollToElement(deActivateAtCheckbox);
        webElementHelper.click(deActivateAtCheckbox);
        return this;
    }

    public UsersPage clickOnExcludefromEmailsCheckbox(){
        webElementHelper.scrollToElement(excludeFromEmailsCheckbox);
        webElementHelper.click(excludeFromEmailsCheckbox);
        return this;
    }

    public UsersPage clickOnAddUserSubmitBtn() throws InterruptedException {
        webElementHelper.scrollToElement(addUserSubmitBtn);
        webElementHelper.click(addUserSubmitBtn);
        return this;
    }





}
