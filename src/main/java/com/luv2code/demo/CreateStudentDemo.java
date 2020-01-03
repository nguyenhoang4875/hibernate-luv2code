package com.luv2code.demo;


import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();

        // create session
        Session  session = sessionFactory.getCurrentSession();
        try {
           // use the session object to save Java object

           // crate a student object
            System.out.println("Creating new Student object ...");
            Student student = new Student("Paul","Wall","paul@luv2code.com");

            // start a transaction
            session.beginTransaction();

           // save the student object
            System.out.println("Saving the student ...");
            session.save(student);

           // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            sessionFactory.close();
        }

    }
}
