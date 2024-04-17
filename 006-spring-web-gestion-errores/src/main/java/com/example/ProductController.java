package com.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("products")
    public String getForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products")
    public String createProduct(Model model, @Valid Product product, BindingResult validation) {
        if (validation.hasErrors()) {
            return "product-form";
        }

        System.out.println(product);
        model.addAttribute("product", product);
        service.findById(1L);
        return "product-info";
    }
}
