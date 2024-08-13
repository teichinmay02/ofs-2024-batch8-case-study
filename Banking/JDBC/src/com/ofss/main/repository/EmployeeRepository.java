package com.ofss.main.repository;

import java.util.List;

import com.ofss.main.domain.Employee;

public interface EmployeeRepository 
{
    List<Employee> getAllEmployees();
    Employee getEMployeeByEmployeeID(int employeeID);
    boolean addNewEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployeeByEmployeeID(int employeeID);
}
