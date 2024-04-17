package com.example.springintro;

import com.example.springintro.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIntroApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIntroApplication.class, args);

        EmployeeController employeeController = context.getBean(EmployeeController.class);
        System.out.println(employeeController.hello());
    }

}
