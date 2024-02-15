package com.fall23.IU.data;

import com.fall23.IU.entity.BookStoreUser;
import com.fall23.IU.entity.Employee;
import com.fall23.IU.entity.Student;
import com.fall23.IU.entity.User;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

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

    public static Student createNewStusentWithFakerData(){
        Student student = new Student();
        student.setFirstname(faker.name().firstName());
        student.setLastname(faker.name().lastName());
        student.setEmail(faker.internet().emailAddress());
        student.setMobileNumber(faker.phoneNumber().subscriberNumber(10));
        student.setCurrentAddress(faker.address().fullAddress());
        return student;
    }


    //HW BookStoreLoginPage
    public static BookStoreUser createNewUserOfBookSoreWithFakerData(){
        BookStoreUser bookStoreUser = new BookStoreUser();
        bookStoreUser.setFirstname(faker.name().firstName());
        bookStoreUser.setLastname(faker.name().lastName());
        return bookStoreUser;
    }

    public static User createNewUserWithFakerData(){
        User user = new User();
        user.setFirstname(faker.name().firstName());
        user.setLastname(faker.name().lastName());
        user.setEmailAddress(faker.internet().emailAddress());
        user.setUsername(faker.name().username());
//        user.setPassword(faker.internet().password(10, 30));
//        String password = RandomStringUtils.randomAlphanumeric(10);
//        user.setPassword(password);
        user.setBio("Lorem Ipsum is simply dummy text of the printing and " +
                "typesetting industry. Lorem Ipsum has been the industry's standard dummy " +
                "text ever since the 1500s, when an unknown printer took a galley of type and " +
                "scrambled it to make a type specimen book. It has survived not only five centuries.");
        return user;
    }


}
