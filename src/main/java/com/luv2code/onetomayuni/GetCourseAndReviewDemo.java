package com.luv2code.onetomayuni;


import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();
        try {


            // start a transaction
            session.beginTransaction();

            // get the course
            int theId = 10;
            Course  course = session.get(Course.class,theId);


            // print the course
            System.out.println(course);

            // print the course reviews
            System.out.println(course.getReviews());


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
