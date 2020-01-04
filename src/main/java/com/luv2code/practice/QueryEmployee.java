package com.luv2code.practice;

import com.luv2code.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployee {
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

            // write somethings to query
            // use executeUpdate when update

            // example get employee where id > 50
            List<Employee> employees = session.createQuery("from Employee s where s.id>50").getResultList();
            employees.forEach(System.out::println);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
