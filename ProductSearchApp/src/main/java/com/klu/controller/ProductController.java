package com.klu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Product;
import com.klu.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService service;
	@GetMapping("/debug")
	public String debug() {
	    return "Controller is working";
	}
	@PostMapping
	public Product save(@RequestBody Product product) {
	    return service.save(product);
	}
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filterByPrice(
            @RequestParam double min,
            @RequestParam double max) {
        return service.filterByPrice(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return service.getSortedProducts();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return service.getExpensiveProducts(price);
    }

}
