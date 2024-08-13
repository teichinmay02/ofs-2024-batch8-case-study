package com.ofss.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args)
    {
        System.out.println("main start");

        String url="jdbc:mysql://localhost:3306/banking_db";
        String username="root";
        String password="root";

        String driverName="com.mysql.cj.jdbc.Driver";
        Connection conn = null;

        try 
        {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password );

            if (conn != null) 
                System.out.println("Connection Successful"); 
        } 

        catch (ClassNotFoundException e) 
        {
            // TODO Auto-generated catch block
            System.out.println("Failed to load Driver Class");
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            System.out.println("Failed to connect to db");
            e.printStackTrace();
        }
        
        finally
        {
            try 
            {
                conn.close();
            } 
            catch (SQLException e) 
            {
                // TODO Auto-generated catch block
                System.out.println("Faild to close connection");
                e.printStackTrace();
            }
        }
        System.out.println("main end");
    }
}
