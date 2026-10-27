package com.abdalrahman.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(1L);
        s1.setName("Abdalrahman");
        s1.setLevel("Senior");

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.abdalrahman.hibernate.Student.class);
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();
    }
}