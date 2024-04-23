package com.example.controller;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String findAll(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "product_list";
    }

    @GetMapping("/products/new")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products/new")
    public String submit(@ModelAttribute Product product,
                         @RequestParam("file")MultipartFile file){
//        if (!file.isEmpty()) {
//            String image = storageService.store(file);
//            String imageUrl = MvcUriComponentsBuilder.fromMethodName(FileController.class, "serveFile", image).build().toUriString();
//            product.setImage(imageUrl);
//        }
        productRepository.save(product);
        return "redirect:/products";
    }
}
