package com.luv2code.onetoone;


import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
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

            // get the instructor detail object
            int theId = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);

            // print the instructor detail
            System.out.println("instructorDetail: "+instructorDetail);

            // print the associated instructor
            System.out.println("the associated instructor: "+ instructorDetail.getInstructor());

            // now let's delete the instructor detail
            System.out.println("Deleting instructorDetail: "+ instructorDetail);

            // remove the associated object reference
            // break bi-directional link

            instructorDetail.getInstructor().setInstructorDetail(null);



            session.delete(instructorDetail);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception ex){
            ex.printStackTrace();

        }
        finally {
            // handle connection leak issue
            session.close();
            sessionFactory.close();
        }

    }
}
