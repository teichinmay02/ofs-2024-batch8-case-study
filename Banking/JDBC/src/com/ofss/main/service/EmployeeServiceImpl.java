package com.ofss.main.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofss.main.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService
{

    private static final String DriverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/banking_db";
    private static final String username = "root";
    private static final String password = "root";

    
    private Connection conn = null;
    private PreparedStatement prep = null;
    private ResultSet resultset = null;
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee_details;";

    
    @Override
    public List<Employee> getAllEmployees() 
    {
        try 
        {
            Class.forName(DriverName);
            conn = DriverManager.getConnection(url, username, password);
            prep = conn.prepareStatement(SELECT_ALL_EMPLOYEES);
            resultset = prep.executeQuery();
    
            List<Employee> employeeList = new ArrayList<>();
            while (resultset.next()) 
            {
                int employeeID = resultset.getInt("emp_id");    
                String first_name = resultset.getString("first_name");
                String last_name = resultset.getString("last_name");
                double salary = resultset.getDouble("salary");
                Employee employee = new Employee(employeeID, first_name, last_name, salary);
                employeeList.add(employee);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
           System.out.println("Failed to connect database");
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmployees'");
    }



    @Override
    public Employee getEMployeeByEmployeeID(int employeeID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEMployeeByEmployeeID'");
    }

    @Override
    public boolean addNewEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNewEmployee'");
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public boolean deleteEmployeeByEmployeeID(int employeeID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployeeByEmployeeID'");
    }

}
