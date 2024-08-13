package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Employee;

public interface EmployeeService 
{
    List<Employee> getAllEmployees();
    Employee getEMployeeByEmployeeID(int employeeID);
    boolean addNewEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployeeByEmployeeID(int employeeID);
}

