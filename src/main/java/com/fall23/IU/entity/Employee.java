package com.fall23.IU.entity;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

// @Data  ----> for lazy SDET and include all these annotations(AllArgsConstructor/Getter/Setter etc)
@AllArgsConstructor  // for creating constructor
@NoArgsConstructor   // default constructor
@Getter              // for getter
@Setter              // for setter
@EqualsAndHashCode   //
@ToString            //
public class Employee {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private int salary;
    private String department;

    public static ArrayList <Employee> getEmployeesFromTable(WebDriver driver){
        // Find the table rows:
        List<WebElement> rows = driver.findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        // спец пустой контейнер чтобы его заполнить данными из rows
        ArrayList<Employee> employees = new ArrayList<>();

        // по одному перебрать этот ряд
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            // первый элемент , ячейку и сохраням каждый так
            String firstName = cells.get(0).getText();
            String lastname = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            // условие на то что, если ряд будет пустым то
            // он не будет добавлять пустые значения и будет уходить на след цикл
            if (firstName.isEmpty() || lastname.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()){
                continue;
        }

            // преобразовываем строку в интежер
            int age = Integer.parseInt(ageText.trim());
            int salary = Integer.parseInt(salaryText.trim());

            // пополняем пустой arrayList
            employees.add(new Employee(firstName, lastname, age, email, salary, department));
        }
        return employees;
    }

    // method to get 1 object (row) and save it in List
//    public static Employee getAndSaveObject(WebElement element){
//
//    }
}


