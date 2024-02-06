package testOrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

// почему тесты в main были, а не в test
public class OrangeHRMLoginTest {
    WebDriver driver1 = new ChromeDriver(); // инициализацию класса лучше делать в before class, а если его нет, то можно и тут на уровне класса

    @BeforeClass
    void openSite(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe"); // // Путь указываем: Test → setProperty → copy Path
        driver1.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver1.manage().window().maximize(); // // manage для управления
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // // будет пытаться открыть 5 секунд

        String actualLoginText = driver1.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);
    }
    @AfterClass
    void closeBrowser(){
        driver1.close();
    }

    /*@BeforeMethod(groups = "1: Valid Values")
    void LoginFieldFindTest(){
        String actualLoginText = driver1.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);
    }*/
    @Test(description = "Login with valid username and valid password", groups = "Valid data", priority = 0)
    void loginValidUsernameValidPasswordTest(){

        String username = "Admin";
        String password = "admin123";

        WebElement usernameInputField = driver1.findElement(By.name("username")); // найди элемент по имени и название этого имени (взяли из html кода)
        WebElement passwordInputField = driver1.findElement(By.name("password"));

        usernameInputField.sendKeys(username); // введи наши данные
        passwordInputField.sendKeys(password);

        WebElement loginBtn = driver1.findElement(By.tagName("button")); // ищет именно по тегу html <button>
        loginBtn.click(); // кликнуть на кнопку

        String actualDashboardText = driver1.findElement(By.tagName("h6")).getText();
        String expectedDashboardText = "Dashboard";
        Assert.assertEquals(actualDashboardText, expectedDashboardText);
    }

    @Test(groups = "Valid data", priority = 1)
    void logoutFromPageTest(){


        WebElement dropdown = driver1.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span"));
        dropdown.click();

        WebElement logout = driver1.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
        logout.click();
//        List<WebElement> webElementList = dropdown.findElements(By.tagName("li"));
//        for (WebElement li : webElementList){
//            if(li.getText().equals("Logout")){
//                li.click();
//            }
//        }
        String actualLoginText = driver1.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);
    }

    @Test(description = "Login with invalid data", groups = "Invalid data", dataProvider = "provider", priority = 2)
    void loginWithInvalidDataTest(String username, String password){

        WebElement usernameInputField = driver1.findElement(By.name("username"));
        WebElement passwordInputField = driver1.findElement(By.name("password"));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);

        WebElement loginBtn = driver1.findElement(By.tagName("button"));
        loginBtn.click();

        String actualFailedLogin = driver1.findElement(By.tagName("p")).getText();
        String expectedFailedLogin = "Invalid credentials";
        Assert.assertEquals(actualFailedLogin, expectedFailedLogin);
    }

    @DataProvider(name = "provider")
    public Object [][] getInvalidData(){
        return new Object[][] {
                {"Admin", "12345"},
                {"12345a", "admin123"},
                {"2fdsa", "sfddfd"}
        };
    }
}
