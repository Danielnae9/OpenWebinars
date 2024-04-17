package com.example;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        var employeeRepository = context.getBean(EmployeeRepository.class);

        List<Employee> employees = List.of(
                new Employee(0, "Daniel", LocalDate.now(), true),
                new Employee(0, "Cristina", LocalDate.now(), false),
                new Employee(0, "Antonio", LocalDate.now(), false),
                new Employee(0, "Sara", LocalDate.now(), true)
        );

        employeeRepository.saveAll(employees);

        employeeRepository.findAllByMarriedTrue().forEach(System.out::println);
    }

}
