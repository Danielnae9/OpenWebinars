package com.example.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Product {

    private Long id;

    @NotNull(message = "Título obligatorio")
    @Size(min = 10, max = 100)
    private String title;

    @NotNull(message = "Fecha obligatorio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate released;

    @NotNull(message = "Precio obligatorio")
    @Min(value = 5)
    private Double price;

    @Valid
    private Manufacturer manufacturer;

    public Product() {
    }

    public Product(Long id, String title, LocalDate released, Double price, Manufacturer manufacturer) {
        this.id = id;
        this.title = title;
        this.released = released;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", released=" + released +
                ", price=" + price +
                '}';
    }
}
