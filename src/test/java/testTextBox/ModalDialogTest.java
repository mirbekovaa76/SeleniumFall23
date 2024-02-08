package testTextBox;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.pages.ModalDialogsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ModalDialogTest {

    WebDriver driver;
    ModalDialogsPage modalDialogsPage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        modalDialogsPage = new ModalDialogsPage();
    }

    @Test(description = "click on Small modal dialogButton")
    void clickSmallModal(){
        driver.get("https://demoqa.com/modal-dialogs");
        String smallModalText = "This is a small modal. It has very less content";
        modalDialogsPage.clickSmallModal();
        String actualSmallModalText = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        Assert.assertEquals(actualSmallModalText, smallModalText);
        modalDialogsPage.closeSmallModal.click();
    }

    @Test(description = "click on Large modal dialog Button")
    void clickLargeModal(){
        driver.get("https://demoqa.com/modal-dialogs");
        String largeModalText = "Lorem Ipsum is simply dummy text of the printing " +
                "and typesetting industry. Lorem Ipsum has been the industry's standard " +
                "dummy text ever since the 1500s, when an unknown printer took a galley of type" +
                " and scrambled it to make a type specimen book. It has survived not only five centuries, " +
                "but also the leap into electronic typesetting, remaining essentially unchanged. It was " +
                "popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        modalDialogsPage.clickLargeModal();
        String actualLargeModalText = driver.findElement(By.xpath("//div[@class='modal-body']//p")).getText();
        Assert.assertEquals(actualLargeModalText, largeModalText);
        modalDialogsPage.closeLargeModal.click();
    }
}
