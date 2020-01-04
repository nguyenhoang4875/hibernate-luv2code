package com.luv2code.practice;

import com.luv2code.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {
    public static void main(String[] args) {

        // create sessionFactory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Employee.class)
                                            .buildSessionFactory();
        // creat session
        Session session = sessionFactory.getCurrentSession();
        try {
            // start a transaction
            session.beginTransaction();

            // create and save 100 employee

            for (int i = 0; i <100 ; i++) {

                // create Employee
                Employee employee = new Employee("Teo"+i, "Le"+i, "google"+i);
                System.out.println(employee);
                // insert employee into database

                session.save(employee);

                // commit session
            }

            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
           sessionFactory.close();
        }
    }
}
