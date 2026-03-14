package com.klu.controller;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // 1️⃣ Category Search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // 2️⃣ Price Filter
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min,
                                       @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // 3️⃣ Sorted by Price
    @GetMapping("/sorted")
    public List<Product> sortedProducts() {
        return repo.findAllSortedByPrice();
    }

    // 4️⃣ Expensive Products
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }
}