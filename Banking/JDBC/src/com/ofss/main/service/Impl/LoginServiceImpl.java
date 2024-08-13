package com.ofss.main.service.Impl;

import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.service.LoginService;
import com.ofss.main.service.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    private DatabaseUtil databaseUtil;
    public CustomerRepository customerRepository;

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/i_nb";
    private static final String userName = "root";
    public static final String password = "root";

    public LoginServiceImpl(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
    }

    public LoginServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean login(int loginId, String password) {
        return customerRepository.login(loginId, password);
    }

    @Override
    public Login createNewLogin(Login login) {
        // Implementation for creating new login
        return login;
    }

    @Override
    public Login validateLogin(Login login) {
        String sql = "SELECT * FROM customer_details WHERE email = ? AND password = ?";
        try (Connection connection = databaseUtil.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getPassword());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    login.setCustomerId(resultSet.getInt("customer_id"));
                    return login;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // @Override
    // public boolean login(int login_id, String password) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'login'");
    // }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }

    public void setDatabaseUtil(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static String getDrivername() {
        return driverName;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }
}
