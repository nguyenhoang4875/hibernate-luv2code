package com.luv2code.onetoone;


import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .buildSessionFactory();

        // create session
        Session  session = sessionFactory.getCurrentSession();
        try {
            // create the objects
/*
            Instructor instructor = new Instructor("Chad","Darby","darby@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("https://www.lv2code.com/youtebe","luv 2 code !!!");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);
*/

            // create the objects
            Instructor instructor = new Instructor("Madhu","Patel","madhu@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com","Guitar");

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
            sessionFactory.close();
        }

    }
}
