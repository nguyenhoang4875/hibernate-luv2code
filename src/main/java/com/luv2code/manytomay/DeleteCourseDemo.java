package com.luv2code.manytomay;


import com.luv2code.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
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

            // get the pacman course from database
            int courseId = 10;
            Course course = session.get(Course.class,courseId);

            // delete the course
            System.out.println("Deleting course: "+ course);

            session.delete(course);

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
