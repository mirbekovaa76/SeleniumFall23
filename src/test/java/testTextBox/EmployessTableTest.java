package testTextBox;

import com.fall23.IU.data.JavaFaker;
import com.fall23.IU.drivers.Driver;
import com.fall23.IU.entity.Employee;
import com.fall23.IU.pages.WebTablePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

import static com.fall23.IU.entity.Employee.getEmployeesFromTable;

public class EmployessTableTest {

    @Test
    void employeesTableTest() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/webtables");

        Employee randomEmployee = JavaFaker.createNewEmployessWithFakerData();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.fillUpTheForm(randomEmployee);

        List<Employee> employees = getEmployeesFromTable(driver);

        employees.forEach(System.out::println);

        // метод чтобы узнать общую сумму зарплаты
//        int totalSalaryAmount = employees.stream()     // открываем поток ()
//                // мапить --> преобразовывать один тип в другой  (синоним парсить)
//                .mapToInt(Employee::getSalary)
//                .sum();
//        System.out.println(totalSalaryAmount);


        // тот же метод но с использованием for each:
        /* int total = 0;
        for(Employee employee : employees){
            total += employee.getSalary();
            System.out.println(total + " total");
        } */
    }

    // TODO verify all employees data

}


