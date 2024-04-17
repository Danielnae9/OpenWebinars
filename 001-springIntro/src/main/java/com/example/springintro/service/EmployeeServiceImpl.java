package com.example.springintro.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public String hello() {
        return "Hola mundo!";
    }
}
