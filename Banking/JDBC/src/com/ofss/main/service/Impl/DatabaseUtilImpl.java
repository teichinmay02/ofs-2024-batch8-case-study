package com.ofss.main.service.Impl;

import com.ofss.main.service.DatabaseUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilImpl implements DatabaseUtil {
    
    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load MySQL JDBC Driver");
        }
    }

    @Override
    public Connection getConnection(String url, String userName,String password) throws SQLException {
        return DriverManager.getConnection(url, userName,password);
    }

    // @Override
    // public Connection getConnection(String url, String username, String password) throws SQLException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
    // }
}
