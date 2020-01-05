package com.luv2code.manytomay;


import com.luv2code.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();
        try {


            // start a transaction
            session.beginTransaction();

            // create course
            Course course = new Course("Pacman - How to score one million points");


            // save the course
            System.out.println("\nSaving the course...");
            session.save(course);
            System.out.println("Saved the course: "+course);

            // create students
            Student student1 = new Student("John","Doe","john@luv2code.com");
            Student student2 = new Student("Mary","Public","mary@luv2code.com");

            // add students to the course
            course.addStudent(student1);
            course.addStudent(student2);

            // save the students
            System.out.println("\nSaving students ...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: "+course.getStudents());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            // add clean up code
            session.close();

            sessionFactory.close();
        }

    }
}
