package com.example.crud.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.crud.entity.Product;
import com.example.crud.util.HibernateUtil;

public class ProductDAO {

    public void saveProduct(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }

    public Product getProduct(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Product p = s.get(Product.class, id);
        s.close();
        return p;
    }

    public void updateProduct(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.update(p);
        tx.commit();
        s.close();
    }

    public void deleteProduct(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.delete(p);
        tx.commit();
        s.close();
    }
}
