package com.example.springexample;

public class CountriesNotFoundException extends RuntimeException{
    CountriesNotFoundException(Long id){
        super("Could not find country " + id);
    }
}
