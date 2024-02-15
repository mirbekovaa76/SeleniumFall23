package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.helper.DropDownHelper;
import com.fall23.IU.helper.WebElementHelper;
import com.fall23.IU.pages.SelectMenuPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuTest {

    @Test
    void demo1(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/select-menu");

        SelectMenuPage selectMenuPage = new SelectMenuPage();
        WebElementHelper webElementHelper = new WebElementHelper();
        DropDownHelper dropDownHelper = new DropDownHelper();

        dropDownHelper.selectByText(selectMenuPage.olldStyleSelectMenu, "Green");

        // вывести список элементов
        List<String> list = dropDownHelper.getAllDropdownValue(selectMenuPage.olldStyleSelectMenu);
        list.forEach(System.out::println);

        // с помощью enum Keys, чтобы введенное в дропдаун значение нажался сразу
        webElementHelper.sendKeysWithEnter(selectMenuPage.selectValueInput, "Pro");
        selectMenuPage.selectValueInput.sendKeys(Keys.ENTER);


    }

    //TODO other options of select


    //
}
