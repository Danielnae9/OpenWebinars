package com.example.service;

import com.example.model.Manufacturer;
import com.example.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    //RETRIEVE
    List<Manufacturer> findAll();
    List<Manufacturer> findAllByYear(Integer year);
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> findByName(String name);

    //CREATE
    Manufacturer save (Manufacturer manufacturer);

    //DELETE
    void deleteById(Long id);
    void deleteAll();

}
