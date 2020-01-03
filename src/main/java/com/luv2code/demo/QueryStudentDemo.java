package com.luv2code.demo;


import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();
        try {

            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(students);

            // query students: lastName = "Doe"
            students = session.createQuery("from Student  s where s.lastName='Doe'").list();

            // display the students
            System.out.println("\nStudents who have last name of Doe");
            displayStudents(students);

            // query students: lastName = "Doe" OR firstName="Daffy"
            students = session.createQuery("from Student s where " +
                                                "s.lastName='Doe' or s.firstName='Daffy'").list();
            // display the students
            System.out.println("\nStudents who have last name of Doe or firstName Daffy");
            displayStudents(students);

            // query students where email LIKE '%luv2code.com'
            System.out.println("\nStudents who have last name of Doe or firstName Daffy");
            students = session.createQuery("from Student  s where " +
                                            "s.email LIKE '%luv2code.com'").list();
            // display the students
            System.out.println("\nStudents who have email like luv2code.com");
            displayStudents(students);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
