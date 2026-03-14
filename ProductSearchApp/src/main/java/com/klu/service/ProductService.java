package com.klu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.entity.Product;
import com.klu.repository.ProductRepo;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductService {
	 private final ProductRepo repository;
	 public Product save(Product product) {
		    return repository.save(product);
		}
	    public List<Product> getByCategory(String category) {
	        return repository.findByCategory(category);
	    }

	    public List<Product> filterByPrice(double min, double max) {
	        return repository.findByPriceBetween(min, max);
	    }

	    public List<Product> getSortedProducts() {
	        return repository.sortProductsByPrice();
	    }

	    public List<Product> getExpensiveProducts(double price) {
	        return repository.findExpensiveProducts(price);
	    }
}
