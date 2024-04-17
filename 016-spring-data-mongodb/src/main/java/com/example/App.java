package com.example;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repo = context.getBean(EmployeeRepository.class);

        repo.deleteAll();

        List<Employee> employees = List.of(
                new Employee(null, "emp1", "emp1@gmail.com", LocalDate.of(1990, 1, 1)),
                new Employee(null, "emp2", "emp2@gmail.com", LocalDate.of(1992, 1, 1)),
                new Employee(null, "emp3", "emp3@gmail.com", LocalDate.of(1995, 1, 1)),
                new Employee(null, "emp4", "emp4@gmail.com", LocalDate.of(1995, 1, 1)),
                new Employee(null, "emp5", "emp5@gmail.com", LocalDate.of(1995, 1, 1)),
                new Employee(null, "emp5", "emp5@gmail.com", LocalDate.of(1994, 1, 1))
        );

        repo.saveAll(employees);

        repo.findAll().forEach(System.out::println);

        System.out.println("Count: " + repo.countAllByName("emp5"));
        System.out.println("Count: " + repo.countAllByNameQuery("emp5"));

        var mongo = context.getBean(MongoTemplate.class);
    }

}
