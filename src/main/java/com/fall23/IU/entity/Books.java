package com.fall23.IU.entity;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Books {

    private String image;
    private String title;
    private String author;
    private String publisher;

    public static ArrayList<Books> getBooksFromTable(WebDriver driver) {
        // find the table rows
        List<WebElement> rows = driver.findElements(By.cssSelector(".rt-tr-group"));

        // created empty list
        ArrayList<Books> books = new ArrayList<>();

        for (WebElement row : rows){

            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));

            String image = cells.get(0).getText();
            String title = cells.get(1).getText();
            String author = cells.get(2).getText();
            String publisher = cells.get(3).getText();

            if(image.isEmpty() || title.isEmpty() || author.isEmpty() || publisher.isEmpty()){
                continue;
            }

            books.add(new Books(image, title, author, publisher));
        }
        rows.stream().forEach(element -> System.out.println(element.getText()));

        return books;




    }
}
