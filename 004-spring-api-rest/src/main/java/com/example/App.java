package com.example;

import com.example.model.Manufacturer;
import com.example.repository.ManufacturerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        var repository = context.getBean(ManufacturerRepository.class);
        repository.save(new Manufacturer(null, "Ferrari", 100000, 1914));
    }

}
