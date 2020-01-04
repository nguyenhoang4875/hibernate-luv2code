package com.luv2code.practice;

import com.luv2code.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
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

            // id employ you want update
            int idEmployee = 1;
            Employee employee = session.get(Employee.class, idEmployee);
            employee.setFirstName("Teo dep trai");

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
