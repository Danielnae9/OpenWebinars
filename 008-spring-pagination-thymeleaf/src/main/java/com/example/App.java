package com.example;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repo = context.getBean(EmployeeRepository.class);
        List<Employee> employees = List.of(
                new Employee(null, "Manolo1", "1", "manolin1@gmail.com"),
                new Employee(null, "Manolo2", "2", "manolin2@gmail.com"),
                new Employee(null, "Manolo3", "3", "manolin3@gmail.com"),
                new Employee(null, "Manolo4", "4", "manolin4@gmail.com"),
                new Employee(null, "Manolo5", "5", "manolin5@gmail.com"),
                new Employee(null, "Manolo6", "6", "manolin6@gmail.com"),
                new Employee(null, "Manolo7", "7", "manolin7@gmail.com"),
                new Employee(null, "Manolo8", "8", "manolin8@gmail.com"),
                new Employee(null, "Manolo9", "9", "manolin9@gmail.com"),
                new Employee(null, "Manolo10", "10", "manolin10@gmail.com"),
                new Employee(null, "Manolo11", "11", "manolin11@gmail.com"),
                new Employee(null, "Manolo12", "12", "manolin12@gmail.com"),
                new Employee(null, "Manolo13", "13", "manolin13@gmail.com"),
                new Employee(null, "Manolo14", "14", "manolin14@gmail.com"),
                new Employee(null, "Manolo15", "15", "manolin15@gmail.com"),
                new Employee(null, "Manolo16", "16", "manolin16@gmail.com"),
                new Employee(null, "Manolo17", "17", "manolin17@gmail.com"),
                new Employee(null, "Manolo18", "18", "manolin18@gmail.com"),
                new Employee(null, "Manolo19", "19", "manolin19@gmail.com"),
                new Employee(null, "Manolo20", "20", "manolin20@gmail.com")
        );

        repo.saveAll(employees);
    }

}
