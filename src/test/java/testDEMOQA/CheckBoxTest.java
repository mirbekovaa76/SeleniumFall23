package testDEMOQA;

import com.fall23.DEMOQA.BaseTest;
import org.testng.annotations.Test;
import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementByXPath;
import static com.fall23.DEMOQA.WebElementManager.scrollPage;
import static org.testng.Assert.*;

public class CheckBoxTest extends BaseTest {

    @Test(description = "Click Home btn and select all with one-click", priority = 0)
    void HomeOneClickTest() {
        openTheSite("https://demoqa.com/checkbox");
        actions.click(findElementByXPath("(//span[@class='rct-checkbox'])[1]")).perform();
        String actualHomeFolderClickMessage = findElementByXPath("(//span[@class='text-success'])[17]").getText();
        assertEquals(actualHomeFolderClickMessage, "excelFile");
    }

    @Test(description = "Click Home btn, opening 1st area and comparing the inner content of this area", priority = 1)
    void HomeBtnClickTest() throws InterruptedException {
        openTheSite("https://demoqa.com/checkbox");
        actions.click(findElementByXPath("(//button[@aria-label='Toggle'])[1]")).perform(); // click Home btn
        String desktopText = findElementByXPath("(//span[@class='rct-title'])[2]").getText();
        String documentsText = findElementByXPath("(//span[@class='rct-title'])[3]").getText();
        String downloadText = findElementByXPath("(//span[@class='rct-title'])[4]").getText();

        boolean showingAllFolders = false;
        if (desktopText.equals("Desktop") && documentsText.equals("Documents") && downloadText.equals("Downloads")) {
            showingAllFolders = true;
            assertTrue(showingAllFolders);
        } else {
            System.err.println("Pls refresh this page");
        }
    }

    @Test(description = "Click Desktop btn, opening 2nd area and comparing the inner content of this area", groups = {"Desktop area"}, dependsOnMethods = {"HomeBtnClickTest"})
    void DesktopBtnClickExpandedTest() {
        // сайт не нужно открывать, т.к. уже открыт в тесте выше
        actions.click(findElementByXPath("(//button[@aria-label='Toggle'])[2]")).perform(); // click Desktop btn
        String actualOpenedToggle = findElementByXPath("(//li[contains(@class, 'expanded')])[2]").getText();
        // String actualOpenedToggle = Desktop Notes Commands
        assertTrue(actualOpenedToggle.contains("Notes")); // true;

    }
    @Test(description = "Select 2 checkboxes and comparing icon changes", groups = {"Desktop area"}, priority = 2)
    void DesktopChangingIconTest() throws InterruptedException { // click on all checkboxes
        actions.click(findElementByXPath("(//span[@class='rct-checkbox'])[3]")).perform(); // click notes
        actions.click(findElementByXPath("(//span[@class='rct-checkbox'])[4]")).perform(); // click commands
        String actualFullCheckIcon = findElementByXPath("(//*[name()='svg' and contains(@class, 'icon-check')])[1]").getText(); // иконка галочки Desktop. перед последним ассертом станет [2], [1] будет иконка Home
        assertFalse(actualFullCheckIcon.contains("half-check")); // Ожидаю false, т.к. actualFullCheckIcon не содержит "half-check"
                                                                 // actualFullCheckIcon = "icon-check"
        Thread.sleep(500);
    }

    @Test(description = "Click Documents, opening 3rd area and comparing the inner content of this area", groups = {"Documents area"}, dependsOnGroups = {"Desktop area"})
    void DocumentsBtnClickExpandedTest() {
        actions.click(findElementByXPath("(//button[@aria-label='Toggle'])[3]")).perform(); // click Documents
        actions.click(findElementByXPath("(//button[@aria-label='Toggle'])[4]")).perform(); // click WorkSpace (under Documents)
        actions.click(findElementByXPath("(//button[@aria-label='Toggle'])[5]")).perform(); // click Office (under Documents)
        String actualOpenedToggle = findElementByXPath("(//li[contains(@class, 'expanded')])[3]").getText();
        // String actualOpenedToggle = Documents WorkSpace React Angular Veu Office и т.д.
        // (мб тут лучше List<String> + for each + check every element);

        boolean documentsCheckFiles = false;
        if (actualOpenedToggle.contains("React") && actualOpenedToggle.contains("General")){ // first and last elements
            documentsCheckFiles = true;
            assertTrue(documentsCheckFiles);
        } else {
            System.err.println("Doesn't contain");
        }
    }
    @Test(description = "Click WorkSpace and Office btns, select both and comparing icon changes", groups = {"Documents area"}, priority = 3)
    void DocumentsChangingIconTest() { // click on 2 checkboxes
        actions.click(findElementByXPath("(//span[@class='rct-checkbox'])[6]")).perform(); // click WorkSpace
        actions.click(findElementByXPath("(//span[@class='rct-checkbox'])[10]")).perform(); // click Office
        String actualFullCheckIcon = findElementByXPath("(//*[name()='svg' and contains(@class, 'icon-check')])[4]").getText();
        assertFalse(actualFullCheckIcon.contains("half-check"));
    }

    @Test(description = "Click Downloads btn, opening 4th area and comparing the inner content of this area", groups = {"Downloads area"}, dependsOnGroups = {"Documents area"})
    void DownloadsBtnClickExpandedTest() throws InterruptedException {
        actions.click(findElementByXPath("(//button[@aria-label='Toggle'])[6]")).perform(); // click Downloads
        String actualOpenedToggle = findElementByXPath("(//li[contains(@class, 'expanded')])[6]").getText();

        boolean downloadsCheckFiles = false;
        if (actualOpenedToggle.contains("Word File.doc") && actualOpenedToggle.contains("Excel File.doc")){
            downloadsCheckFiles = true;
            assertTrue(downloadsCheckFiles);
        } else {
            System.err.println("Doesn't contain");
        }
        Thread.sleep(500);
    }
    @Test(description = "Select 2 checkboxes and comparing icon changes", groups = {"Downloads area"}, priority = 4)
    void DownloadsChangingIconTest() {
        scrollPage();
        actions.click(findElementByXPath("(//span[@class='rct-checkbox'])[16]")).perform(); // click Word File
        actions.click(findElementByXPath("(//span[@class='rct-checkbox'])[17]")).perform(); // click Excel file
        String actualDownloadFullCheckIcon = findElementByXPath("(//*[name()='svg' and contains(@class, 'icon-check')])[15]").getText(); // иконка галочки Downloads
        assertFalse(actualDownloadFullCheckIcon.contains("half-check"));
    }
}
// Structure:
// 1. Home checkbox, select all with one-click

// 2. 1st area - click Home btn, opening and comparing files
// select checkboxes, comparing icon changes

// 3. 2nd area - click Desktop bnt, opening and comparing inner folders and files
// select checkboxes, comparing icon changes

// 4. 3rd area - click Download btn, opening and comparing files