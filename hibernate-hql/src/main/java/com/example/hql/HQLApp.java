package com.example.hql;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HQLApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Insert products
        session.save(new Product("Laptop", "Electronics", 70000, 5));
        session.save(new Product("Mouse", "Accessory", 1200, 20));
        session.save(new Product("Keyboard", "Accessory", 1500, 10));
        session.save(new Product("Monitor", "Display", 12000, 4));
        session.save(new Product("Printer", "Office", 9000, 2));
        session.save(new Product("Speaker", "Audio", 3000, 8));
        session.save(new Product("Webcam", "Accessory", 4000, 0));

        tx.commit();

        // 3a Price Ascending
        System.out.println("\nPrice Ascending:");
        session.createQuery("from Product order by price asc", Product.class)
               .list().forEach(System.out::println);

        // 3b Price Descending
        System.out.println("\nPrice Descending:");
        session.createQuery("from Product order by price desc", Product.class)
               .list().forEach(System.out::println);

        // 4 Quantity Highest First
        System.out.println("\nQuantity High to Low:");
        session.createQuery("from Product order by quantity desc", Product.class)
               .list().forEach(System.out::println);

        // 5a Pagination: First 3
        System.out.println("\nFirst 3 Products:");
        Query<Product> p1 = session.createQuery("from Product", Product.class);
        p1.setFirstResult(0);
        p1.setMaxResults(3);
        p1.list().forEach(System.out::println);

        // 5b Pagination: Next 3
        System.out.println("\nNext 3 Products:");
        Query<Product> p2 = session.createQuery("from Product", Product.class);
        p2.setFirstResult(3);
        p2.setMaxResults(3);
        p2.list().forEach(System.out::println);

        // 6a Count total products
        Long total = session.createQuery(
                "select count(*) from Product", Long.class).uniqueResult();
        System.out.println("\nTotal Products: " + total);

        // 6b Count quantity > 0
        Long available = session.createQuery(
                "select count(*) from Product where quantity > 0", Long.class)
                .uniqueResult();
        System.out.println("Available Products: " + available);

        // 6c Count grouped by description
        System.out.println("\nCount by Description:");
        session.createQuery(
                "select description, count(*) from Product group by description")
                .list().forEach(System.out::println);

        // 6d Min & Max price
        Object[] mm = session.createQuery(
                "select min(price), max(price) from Product", Object[].class)
                .uniqueResult();
        System.out.println("\nMin Price: " + mm[0] + " Max Price: " + mm[1]);

        // 7 Group by description
        System.out.println("\nGroup By Description:");
        session.createQuery(
                "from Product group by description", Product.class)
                .list().forEach(System.out::println);

        // 8 Price range filter
        System.out.println("\nPrice between 2000 and 10000:");
        session.createQuery(
                "from Product where price between 2000 and 10000",
                Product.class)
                .list().forEach(System.out::println);

        // 9 LIKE queries
        System.out.println("\nName starts with 'M':");
        session.createQuery(
                "from Product where name like 'M%'", Product.class)
                .list().forEach(System.out::println);

        System.out.println("\nName ends with 'r':");
        session.createQuery(
                "from Product where name like '%r'", Product.class)
                .list().forEach(System.out::println);

        System.out.println("\nName contains 'ea':");
        session.createQuery(
                "from Product where name like '%ea%'", Product.class)
                .list().forEach(System.out::println);

        System.out.println("\nName length = 5:");
        session.createQuery(
                "from Product where length(name)=5", Product.class)
                .list().forEach(System.out::println);

        session.close();
    }
}
