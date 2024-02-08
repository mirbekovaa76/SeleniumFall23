package com.fall23.IU.data;

import com.fall23.IU.entity.Employee;
import com.github.javafaker.Faker;

public class JavaFaker {

    static Faker faker = new Faker();

    public static Employee createNewEmployessWithFakerData(){
        Employee employee = new Employee();
        employee.setFirstname(faker.name().firstName());
        employee.setLastname(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
        employee.setAge(faker.number().randomDigit());
        employee.setSalary(faker.number().randomDigit());
        employee.setDepartment(faker.commerce().department());
        return employee;
    }
}
