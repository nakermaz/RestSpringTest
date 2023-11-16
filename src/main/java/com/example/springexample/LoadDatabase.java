package com.example.springexample;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CountriesRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Countries("USA")));
            log.info("Preloading " + repository.save(new Countries("KAZAKHSTAN")));
        };
    }
}
