package testDEMOQA.MouseInteractions;

import com.fall23.DEMOQA.BaseTest;
import org.testng.annotations.Test;
import static com.fall23.DEMOQA.WebDriverManager.openTheSite;
import static com.fall23.DEMOQA.WebElementManager.findElementById;
import static org.testng.Assert.assertEquals;

public class DownloadFileTextTest extends BaseTest {

    @Test
    void downloadTest() throws InterruptedException {
        openTheSite("https://demoqa.com/upload-download");
        //send keys можно загружать файлы
        findElementById("uploadFile").sendKeys("C:\\Users\\User\\Downloads\\DSCF9568 (1).jpg");
        Thread.sleep(3000);
    }
}
