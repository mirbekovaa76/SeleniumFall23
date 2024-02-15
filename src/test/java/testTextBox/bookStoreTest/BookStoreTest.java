package testTextBox.bookStoreTest;

import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.Books;
import com.fall23.IU.pages.hwBookStoreApp.BookStorePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.fall23.IU.entity.Books.getBooksFromTable;

public class BookStoreTest {

    WebDriver driver;
    BookStorePage bookStorePage;

    @BeforeClass
    void setUpDriver(){
        driver = Driver.getDriver();
        bookStorePage = new BookStorePage();
    }

    @Test
    void addBookToCollection(){
        driver.get("https://demoqa.com/profile");
        bookStorePage.clickGoToStoreBtn()
                .clickOnJavaLearningBook()
                .clickAddToCollectionBtn();

    }




   // return books list in a console
    @Test
    void returnBooksTest(){
        driver.get("https://demoqa.com/books");

        List<Books> books = getBooksFromTable(driver);
        books.forEach(System.out::println);
    }
}
