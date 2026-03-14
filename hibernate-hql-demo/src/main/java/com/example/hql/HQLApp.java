 package com.example.hql;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HQLApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Insert Products
        session.save(new Product("Laptop", "Electronics", 70000, 5));
        session.save(new Product("Mouse", "Accessory", 1200, 20));
        session.save(new Product("Keyboard", "Accessory", 1500, 10));
        session.save(new Product("Monitor", "Display", 12000, 4));
        session.save(new Product("Printer", "Office", 9000, 2));
        session.save(new Product("Speaker", "Audio", 3000, 8));
        session.save(new Product("Webcam", "Accessory", 4000, 0));

        tx.commit();

        // Sort by price ASC
        session.createQuery("from Product order by price asc", Product.class)
                .list().forEach(System.out::println);

        // Sort by price DESC
        session.createQuery("from Product order by price desc", Product.class)
                .list().forEach(System.out::println);

        // Sort by quantity DESC
        session.createQuery("from Product order by quantity desc", Product.class)
                .list().forEach(System.out::println);

        // Pagination - first 3
        Query<Product> q1 = session.createQuery("from Product", Product.class);
        q1.setFirstResult(0);
        q1.setMaxResults(3);
        q1.list().forEach(System.out::println);

        // Pagination - next 3
        Query<Product> q2 = session.createQuery("from Product", Product.class);
        q2.setFirstResult(3);
        q2.setMaxResults(3);
        q2.list().forEach(System.out::println);

        // Aggregate - count total
        Long total = session.createQuery(
                "select count(*) from Product", Long.class)
                .uniqueResult();
        System.out.println("Total Products: " + total);

        // Aggregate - count quantity > 0
        Long available = session.createQuery(
                "select count(*) from Product where quantity > 0", Long.class)
                .uniqueResult();
        System.out.println("Available Products: " + available);

        // Aggregate - min & max price
        Object[] mm = session.createQuery(
                "select min(price), max(price) from Product", Object[].class)
                .uniqueResult();
        System.out.println("Min Price: " + mm[0] + " Max Price: " + mm[1]);

        // Group by description
        session.createQuery(
                "select description, count(*) from Product group by description")
                .list().forEach(System.out::println);

        // Price range
        session.createQuery(
                "from Product where price between 2000 and 10000",
                Product.class)
                .list().forEach(System.out::println);

        // LIKE queries
        session.createQuery(
                "from Product where name like 'M%'", Product.class)
                .list().forEach(System.out::println);

        session.createQuery(
                "from Product where name like '%r'", Product.class)
                .list().forEach(System.out::println);

        session.createQuery(
                "from Product where name like '%ea%'", Product.class)
                .list().forEach(System.out::println);

        session.createQuery(
                "from Product where length(name)=5", Product.class)
                .list().forEach(System.out::println);

        session.close();
    }
}
