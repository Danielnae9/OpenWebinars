package com.example;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ProductErrorAdvice {

    @ExceptionHandler(value = NoSuchElementException.class)
    public ModelAndView handleNoSuch(NoSuchElementException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("product-error");
        return modelAndView;

    }

}
