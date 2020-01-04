package com.luv2code.onetomany;


import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructionDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Course.class)
                                            .buildSessionFactory();

        // create session
        Session  session = sessionFactory.getCurrentSession();
        try {

            // create the objects
            Instructor instructor = new Instructor("Susan","Public","susan@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com","Video Game");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            // Note: this will ALSO save details object
            // because of of CascadeType.ALL
            System.out.println("Saving instructor: "+ instructor);
            session.save(instructor);

           // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            // add clean up code
            session.close();

            sessionFactory.close();
        }

    }
}
