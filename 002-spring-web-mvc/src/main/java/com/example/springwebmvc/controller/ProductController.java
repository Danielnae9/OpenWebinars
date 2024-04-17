package com.example.springwebmvc.controller;

import com.example.springwebmvc.entity.Product;
import com.example.springwebmvc.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String findAll(Model model){

        List<Product> products = this.repository.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/form")
    public String getForm(Model model){

        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/form")
    public String createProduct(@ModelAttribute("product") Product product){

        this.repository.save(product);
        return "redirect:/products";
    }
}
