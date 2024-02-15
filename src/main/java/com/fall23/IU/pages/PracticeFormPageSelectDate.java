package com.fall23.IU.pages;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.DropDownHelper;
import com.fall23.IU.helper.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPageSelectDate {


    public PracticeFormPageSelectDate(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerButton;
                                                     // 01 February 2021
    public PracticeFormPageSelectDate selectDateMonthYear(String dateMonthYear){
        // поделить строку на 3 части через метод сплит
        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        WebElementHelper webElementHelper = new WebElementHelper();
        webElementHelper.click(datePickerButton);

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
}
