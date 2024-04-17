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
        var repo = context.getBean(EmployeeRepository.class);

        List<Employee> employees = List.of(
                new Employee(null, "emp1", 20, "emp1@gmail.com", true, LocalDate.of(1990, 1, 1)),
                new Employee(null, "emp2", 35, "emp2@gmail.com", false, LocalDate.of(1998, 1, 1)),
                new Employee(null, "emp3", 21, "emp3@gmail.com", false, LocalDate.of(1992, 1, 1)),
                new Employee(null, "emp4", 28, "emp4@gmail.com", false, LocalDate.of(1997, 1, 1)),
                new Employee(null, "emp5", 34, "emp5@gmail.com", true, LocalDate.of(1999, 1, 1))
        );
        repo.saveAll(employees);
        repo.findAll().forEach(System.out::println);

        repo.updateMarriedToFalseByBirthDateAfterQuery(LocalDate.of(1995, 1, 1));
        repo.findAll().forEach(System.out::println);
    }

}
