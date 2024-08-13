package com.ofss.main.domain;

public class Employee 
{
    private int EmployeeID;
    private String firstName;
    private String lastname;
    private double salary;

    public Employee(){}

    public Employee(int EmployeeID, String firstName, String lastName, double salary)
    {
        this.EmployeeID = EmployeeID;
        this.firstName = firstName;
        this.lastname = lastName;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
}
