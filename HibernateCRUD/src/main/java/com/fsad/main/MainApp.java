package com.fsad.main;

import com.fsad.dao.ProductDAO;
import com.fsad.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // INSERT
        Product p1 = new Product("Laptop", "Electronics", 60000, 5);
        Product p2 = new Product("Mobile", "Electronics", 30000, 10);

        dao.saveProduct(p1);
        dao.saveProduct(p2);

        // READ
        Product p = dao.getProduct(1);
        System.out.println(p.getName() + " " + p.getPrice());

        // UPDATE
        dao.updateProduct(1, 65000, 7);

        // DELETE
        dao.deleteProduct(2);

        System.out.println("CRUD Operations Completed");
    }
}
