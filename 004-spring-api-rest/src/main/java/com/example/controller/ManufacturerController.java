package com.example.controller;

import com.example.model.Manufacturer;
import com.example.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManufacturerController {

    private ManufacturerService service;

    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }

    @GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> findAll(){
        List<Manufacturer> manufacturers = this.service.findAll();
        if (manufacturers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(manufacturers);
        }
    }

    @GetMapping("/manufacturers/year/{year}")
    public ResponseEntity<List<Manufacturer>> findAllByYear(@PathVariable Integer year){
        List<Manufacturer> manufacturers = this.service.findAllByYear(year);
        if (manufacturers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(manufacturers);
        }
    }

    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id) {
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer) {
        if (manufacturer.getId() != null) {
            return ResponseEntity.badRequest().build();
        } else {
            this.service.save(manufacturer);
            return ResponseEntity.ok(manufacturer);
        }
    }

    @PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer) {
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @DeleteMapping("/manufacturers/{identifier}")
    public ResponseEntity<Manufacturer> deleteById(@PathVariable("identifier") Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
