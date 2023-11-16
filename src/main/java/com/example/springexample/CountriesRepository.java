package com.example.springexample;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CountriesRepository extends JpaRepository<Countries, Long> {
}
