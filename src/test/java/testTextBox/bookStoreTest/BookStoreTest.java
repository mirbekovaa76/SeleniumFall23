package testTextBox.bookStoreTest;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.Books;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.fall23.IU.entity.Books.getBooksFromTable;

public class BookStoreTest {

    WebDriver driver;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
    }
    @Test
    void returnBooksTest(){
        driver.get("https://demoqa.com/books");

        List<Books> books = getBooksFromTable(driver);
        books.forEach(System.out::println);
    }
}
