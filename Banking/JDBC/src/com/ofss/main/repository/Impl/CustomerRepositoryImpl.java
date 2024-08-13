package com.ofss.main.repository.Impl;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.domain.Savings;
import com.ofss.main.domain.Current;
import com.ofss.main.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/i_nb";
    private static final String userName = "root";
    private static final String password = "root";

    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customer_details(first_name, last_name, gender, email, mobile, login_id, customer_status, approved, password, account_type, minimum_balance, overdraft_balance, remaining_overdraft_balance ) VALUES (?, ?, ?, ?, ?, ?, 'NEW', 0,?,?,?,?,?)";
    private static final String CREATE_LOGIN = "INSERT INTO login_details (password, login_attempts, login_status) VALUES (?, 0, 'ACTIVE')";
    private static final String SELECT_LOGIN = "SELECT * FROM login_details WHERE login_id = ?";
    private static final String SELECT_ALLCUSTOMER = "select * from customer_details";
    private static final String UPDATE_LOGIN_ATTEMPTS = "UPDATE login_details SET login_attempts = ?, login_status = ? WHERE login_id = ?";

    @Override
    public Customer addNewCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);

            // Create login record first
            int loginId = createLogin(customer.getLogin(), connection);

            // Create customer record
            preparedStatement = connection.prepareStatement(CREATE_NEW_CUSTOMER, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getGneder());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getMobile());
            preparedStatement.setInt(6, loginId); // Set the login_id
            preparedStatement.setString(7, customer.getPassword());


            // Set the account type and initial values
            if (customer.getAccount() instanceof Savings) {
                preparedStatement.setString(8, "Savings");
                preparedStatement.setDouble(9, ((Savings) customer.getAccount()).getMinimumBalance());
                preparedStatement.setDouble(10, 0); // No overdraft for savings
                preparedStatement.setDouble(11, 0); // No remaining overdraft for savings
            } else if (customer.getAccount() instanceof Current) {
                preparedStatement.setString(8, "Current");
                preparedStatement.setDouble(9, 0); // Minimum balance for current
                preparedStatement.setDouble(10, ((Current) customer.getAccount()).getOverdraftBalance());
                preparedStatement.setDouble(11, ((Current) customer.getAccount()).getRemainingOverdraftBalance());
            }

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedCustomerId = generatedKeys.getInt(1);
                    customer.setCustomerId(generatedCustomerId); // Set the generated ID to the customer object
                    return customer; // Return the customer object with the generated ID
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection");
                e.printStackTrace();
            }
        }
        return null; // Return null if customer creation fails
    }

    private int createLogin(Login login, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;
        try {
            preparedStatement = connection.prepareStatement(CREATE_LOGIN, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, login.getPassword()); // Set the password value
            // preparedStatement.setString(2, "ACTIVE"); // Set a valid value for login_status
          //  preparedStatement.setInt(1, 0);

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated login_id
                }
            }
        } finally {
            if (generatedKeys != null) generatedKeys.close();
            if (preparedStatement != null) preparedStatement.close();
        }
        return 0; // Return 0 if creation fails
    }

    public boolean validateCustomerLogin(int loginId, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
    
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
    
            // Ensure auto-commit is disabled for transaction control
            connection.setAutoCommit(false);
    
            // Query to select login details
            preparedStatement = connection.prepareStatement(SELECT_LOGIN);
            preparedStatement.setInt(1, loginId);
    
            resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) 
            {
                int attempts = resultSet.getInt("login_attempts");
                String status = resultSet.getString("login_status");
                String storedPassword = resultSet.getString("password");
    
                System.out.println("Stored Password: " + storedPassword);
                System.out.println("Input Password: " + password);
                System.out.println("Attempts: " + attempts);
                System.out.println("Status: " + status);
    
                if ("LOCKED".equals(status)) {
                    // Account is locked
                    return false;
                }
    
                if (storedPassword.equals(password)) 
                {
                    // Reset attempts on successful login
                    preparedStatement = connection.prepareStatement(UPDATE_LOGIN_ATTEMPTS);
                    preparedStatement.setInt(1, 0); // Reset attempts
                    preparedStatement.setString(2, "ACTIVE"); // Ensure status is ACTIVE
                    preparedStatement.setInt(3, loginId);
                    int rowsUpdated = preparedStatement.executeUpdate();
                    System.out.println("Rows updated on successful login: " + rowsUpdated);
                    connection.commit();
                    return true;
                } 
                else 
                {
                    // Increment attempts
                    attempts++;
                    String newStatus = (attempts >= 3) ? "LOCKED" : "ACTIVE";
                    preparedStatement = connection.prepareStatement(UPDATE_LOGIN_ATTEMPTS);
                    preparedStatement.setInt(1, attempts);
                    preparedStatement.setString(2, newStatus);
                    preparedStatement.setInt(3, loginId);
                    int rowsUpdated = preparedStatement.executeUpdate();
                    System.out.println("Rows updated on failed login: " + rowsUpdated);
                    connection.commit();
                    return false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerById'");
    }
}
