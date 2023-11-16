package com.example.springexample;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CountriesController {

    private final CountriesRepository repository;

    CountriesController(CountriesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    List<Countries> all(){
        return repository.findAll();
    }


    @PostMapping("/countries")
    Countries newCountries (@RequestBody Countries newCountries){
        return repository.save(newCountries);
    }

    @GetMapping("/countries/{id}")
    Countries one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CountriesNotFoundException(id));
    }

    @PutMapping("/countries/{id}")
    Countries replaceCountries(@RequestBody Countries newCountries, @PathVariable Long id){
        return repository.findById(id)
                .map(countries -> {
                    countries.setName(newCountries.getName());
                    return repository.save(countries);
                }).orElseGet(() -> {
                    newCountries.setId(id);
                    return repository.save(newCountries);
                });
    }

    @DeleteMapping("/countries/{id}")
    void deleteCountries(@PathVariable Long id){
        repository.deleteById(id);
    }
}
