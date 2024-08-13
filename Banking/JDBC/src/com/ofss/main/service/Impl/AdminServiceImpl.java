package com.ofss.main.service.Impl;

import com.ofss.main.domain.Admin;
import com.ofss.main.service.AdminService;
import com.ofss.main.service.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {

    private DatabaseUtil databaseUtil;
    private static final String url = "jdbc:mysql://localhost:3306/i_nb";
    private static final String userName = "root";
    private static final String password = "root";

    // Constructor with DatabaseUtil parameter
    public AdminServiceImpl(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
    }

    // Default constructor should not be needed if using dependency injection
    // Remove or replace if not using dependency injection
    public AdminServiceImpl() {
        throw new UnsupportedOperationException("Default constructor not supported. Use the parameterized constructor.");
    }

    @Override
    public Admin validateAdminLogin(Admin admin) {
        System.out.println(admin.getUsername());
        System.out.println(admin.getPassword());
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (Connection connection = databaseUtil.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Valid admin login
                    admin.setAdminId(resultSet.getInt("admin_id"));
                    return admin;
                } else {
                    // Invalid admin login
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean approveCustomer(int customerId) {
        String sql = "UPDATE customer_details SET approved = TRUE WHERE customer_id = ?";
        try (Connection connection = databaseUtil.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, customerId);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
