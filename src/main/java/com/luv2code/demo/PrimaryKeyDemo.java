package com.luv2code.demo;

import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();
        try {
            // use the session object to save Java object

            // crate 2 student object
            System.out.println("Creating 3 Student object ...");
            Student student1 = new Student("John", "Doe", "john@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student ...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }

    }
}
