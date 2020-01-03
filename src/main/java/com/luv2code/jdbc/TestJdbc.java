package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl ="jdbc:mysql://localhost:3306/hb_student_tracker?userSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Connecting to database: "+ jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println(connection);
            System.out.println("Connect successful");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
