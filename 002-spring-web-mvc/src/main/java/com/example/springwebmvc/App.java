package com.example.springwebmvc;

import com.example.springwebmvc.entity.Product;
import com.example.springwebmvc.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repository = context.getBean(ProductRepository.class);

        List<Product> products = List.of(
                new Product(0, "Producto 1", 39.99, 3),
                new Product(0, "Producto 2", 29.99, 1),
                new Product(0, "Producto 3", 119.99, 6),
                new Product(0, "Producto 4", 119.99, 6),
                new Product(0, "Producto 5", 119.99, 6),
                new Product(0, "Producto 6", 44.99, 7)
        );
        repository.saveAll(products);
    }

}
