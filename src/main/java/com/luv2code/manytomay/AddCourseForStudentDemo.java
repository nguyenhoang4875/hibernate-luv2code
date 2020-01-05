package com.luv2code.manytomay;


import com.luv2code.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseForStudentDemo {
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

            // get the student mary form database
            int theId = 2;
            Student student = session.get(Student.class,theId);

            System.out.println("\nLoaded student: "+ student);
            System.out.println("Courses: "+ student.getCourses());

            // create more course
            Course course1 =  new Course("Rubik's Cube - How to speed Cube");
            Course course2 =  new Course("Atari 2600 - Game Development");

            // add student to courses
            course1.addStudent(student);
            course2.addStudent(student);

            // save the courses
            System.out.println("\nSaving the courses...");
           // session.save(course1);
            session.save(course2);

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
