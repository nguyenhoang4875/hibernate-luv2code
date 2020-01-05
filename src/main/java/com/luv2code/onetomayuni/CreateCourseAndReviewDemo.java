package com.luv2code.onetomayuni;


import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
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

            // create course
            Course course = new Course("Pacman - How to score one million points");

            // add some reviews
            course.addReview(new Review("Great course ... loved it"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("What a dumb course, you are an idiot!"));


            // save the course .. and leverage the cascade all :))
            System.out.println("Saving the course");
            System.out.println(course);
            System.out.println(course.getReviews());

            session.save(course);


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
