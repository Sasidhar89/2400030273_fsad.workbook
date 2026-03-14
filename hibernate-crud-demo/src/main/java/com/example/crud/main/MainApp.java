package com.example.crud.main;

import com.example.crud.dao.ProductDAO;
import com.example.crud.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // INSERT
        Product p1 = new Product("Laptop", "Electronics", 70000, 5);
        dao.saveProduct(p1);

        // RETRIEVE
        Product p = dao.getProduct(1);
        System.out.println(p);

        // UPDATE
        p.setPrice(68000);
        p.setQuantity(4);
        dao.updateProduct(p);

        // DELETE
        //dao.deleteProduct(p);
    }
}
