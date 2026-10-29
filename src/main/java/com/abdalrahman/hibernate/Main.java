package com.abdalrahman.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(2L);
        s1.setName("Basma");
        s1.setLevel("Semi-senior");


        SessionFactory factory = new Configuration()
                .addAnnotatedClass(com.abdalrahman.hibernate.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

//        session.persist(s1);
        Student st = session.get(Student.class,3);
        System.out.println(st);


        session.merge(s1);
        transaction.commit();


        session.close();
        factory.close();
    }
}