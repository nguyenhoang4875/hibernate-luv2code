package com.luv2code.eagervslazy;


import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();
        try {


            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor instructor = session.get(Instructor.class,theId);

            System.out.println("luv2code: Instructor: "+ instructor);
            System.out.println("luv2code: Course :" + instructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nluv2code: The session is now closed\n");
            // option 1: call getter method while session is open

            // get courses the instructor
            System.out.println("luv2code: Course :" + instructor.getCourses());

            System.out.println("luv2code: Done!");
        } finally {
            // add clean up code
            session.close();

            sessionFactory.close();
        }

    }
}
