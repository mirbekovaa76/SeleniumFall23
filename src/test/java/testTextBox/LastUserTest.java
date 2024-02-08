package testTextBox;

import com.fall23.DEMOQA.BaseTest;
import com.fall23.IU.entity.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LastUserTest extends BaseTest {

    @Test
    void testLastUser(){
        driver.get("https://demoqa.com");

        String lastEmployee = driver.findElement(By.xpath("(//div[@class='rt-tr -odd'])[2]")).getText();
        System.out.println(lastEmployee);


    }
}
