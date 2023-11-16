package com.example.springexample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CountriesNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(CountriesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String countriesNotFoundAdvice(CountriesNotFoundException ex){
        return ex.getMessage();
    }
}
