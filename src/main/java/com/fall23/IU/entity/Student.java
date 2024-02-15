package com.fall23.IU.entity;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.DropDownHelper;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.hwPracticeFormPage.PracticeFormPage;
import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {

    private String firstname;
    private String lastname;
    private String email;
    private String mobileNumber;
    private String currentAddress;

}


