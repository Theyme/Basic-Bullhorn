package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    TheymeRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        Theyme theyme = new Theyme("Life is amazing", "01/20/19", "@Beanyman25");
        repository.save(theyme);

        theyme = new Theyme("Just scored a free kick", "12/1/19", "@cr7");
        repository.save(theyme);

        theyme = new Theyme("Life is like a box of chocolate", "09/26/18", "@ForestGump");
        repository.save(theyme);
    }
}