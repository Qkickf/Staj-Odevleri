package com.furkant.jugtours;

import com.furkant.jugtours.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
    private final FilmRepository repository;

    public Initializer(FilmRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
