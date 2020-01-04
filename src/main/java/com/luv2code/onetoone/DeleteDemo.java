package com.luv2code.onetoone;


import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();
        try {

            // start a transaction
            session.beginTransaction();

            // get instructor by primary key/id
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("Found instructor: " + instructor);

            // delete the instructions
            if (instructor != null){
                System.out.println("deleting...: "+ instructor);

                // Note: will Also delete associated "details" object
                // because of CascadeType.ALL
                session.delete(instructor);
            }

                // commit transaction
                session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }

    }
}
