package com.example.springintro.controller;

import com.example.springintro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public String hello () {
        return this.employeeService.hello();
    }

}
