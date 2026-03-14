package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.klu.entity.Product;
import com.klu.repository.ProductRepository;

@SpringBootApplication
public class Exp8Application {

    public static void main(String[] args) {
        SpringApplication.run(Exp8Application.class, args);
    }

    // Sample Data for Exp-8
    @Bean
    CommandLineRunner run(ProductRepository repo) {
        return args -> {
            repo.save(new Product("Laptop","Electronics",75000));
            repo.save(new Product("Phone","Electronics",30000));
            repo.save(new Product("Shoes","Fashion",2500));
            repo.save(new Product("Watch","Fashion",5000));
            repo.save(new Product("TV","Electronics",60000));
        };
    }
}