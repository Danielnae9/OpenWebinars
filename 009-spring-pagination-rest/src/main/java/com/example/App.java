package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repo = context.getBean(EmployeeRepository.class);

        List<Employee> employees = List.of(
                new Employee(null, "Antonio", LocalDate.of(1990, 1, 1), 40000.0, true),
                new Employee(null, "Antonio", LocalDate.of(1997, 5, 7), 140000.0, true),
                new Employee(null, "Felipe", LocalDate.of(1993, 3, 17), 20000.0, false),
                new Employee(null, "Antonio", LocalDate.of(1984, 4, 11), 38000.0, true),
                new Employee(null, "Luis", LocalDate.of(2002, 8, 16), 66000.0, false),
                new Employee(null, "Antonio", LocalDate.of(1991, 5, 4), 14000.0, false),
                new Employee(null, "Bill", LocalDate.of(2000, 9, 21), 5000000.0, true)
        );
        repo.saveAll(employees);
    }

}
