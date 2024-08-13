package com.ofss.main;

import com.ofss.main.domain.Admin;
import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.domain.Savings;
import com.ofss.main.domain.Current;
import com.ofss.main.service.AdminService;
import com.ofss.main.service.CustomerService;
import com.ofss.main.service.LoginService;
import com.ofss.main.service.Impl.AdminServiceImpl;
import com.ofss.main.service.Impl.CustomerServiceImpl;
import com.ofss.main.service.Impl.LoginServiceImpl;
import com.ofss.main.service.DatabaseUtil;
import com.ofss.main.service.Impl.DatabaseUtilImpl;

import java.util.Scanner;

public class BankingMain {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;
        Login login = null;
        Admin admin = null;
        DatabaseUtil databaseUtil = new DatabaseUtilImpl();
        LoginService loginService = new LoginServiceImpl(databaseUtil);
        CustomerService customerService = new CustomerServiceImpl();
        AdminService adminService = new AdminServiceImpl(new DatabaseUtilImpl());

        int mainMenuChoice = printMainMenu(scanner);

        if (mainMenuChoice == 1 || mainMenuChoice == 2) {
            customer = menuOperations(mainMenuChoice, login, customer, scanner);
            if (customer != null && mainMenuChoice == 1) {
                login = customer.getLogin();
                try {
                    login = loginService.createNewLogin(login);
                    System.out.println("Login created successfully!!");
                } catch (Exception e) {
                    System.out.println("Failed to create login: " + e.getMessage());
                    e.printStackTrace();
                    return;
                }

                try {
                    customer = customerService.addNewCustomer(customer);
                    if (customer != null) {
                        System.out.println("Customer created successfully");
                        System.out.println("Waiting for admin approval...");
                        System.out.println("Your customerId :: " + customer.getCustomerId());
                        System.out.println();
                    } else {
                        System.out.println("Failed to create customer");
                    }
                } catch (Exception e) {
                    System.out.println("Failed to create customer: " + e.getMessage());
                    e.printStackTrace();
                    return;
                }
            } else if (mainMenuChoice == 2) {
                System.out.println("Enter your email");
                String email = scanner.next();
                System.out.println("Enter your password");
                String password = scanner.next();

                login = new Login(email, password); // Constructor should match
                Login validatedLogin = loginService.validateLogin(login);
                if (validatedLogin != null) {
                    customer = customerService.getCustomerById(validatedLogin.getCustomerId());
                    if (customer != null && customer.isApproved()) {
                        System.out.println("Login successful, but account is not approved by admin yet.");
                    } else {
                        System.out.println("Login successful");
                    }
                } else {
                    System.out.println("Invalid email or password");
                }
            } else {
                System.out.println("Thank you!");
            }
        } else if (mainMenuChoice == 3) {
            admin = adminLogin(scanner);
            if (admin != null) {
                System.out.println("Admin login successful");
                System.out.println("Enter customer ID to approve:");
                int customerId = scanner.nextInt();
                if (adminService.approveCustomer(customerId)) {
                    System.out.println("Customer approved successfully");
                } else {
                    System.out.println("Failed to approve customer");
                }
            } else {
                System.out.println("Invalid admin credentials");
            }
        } else {
            System.out.println("Thank you!");
        }
    }

    private static int printMainMenu(Scanner scanner) {
        System.out.println("Main Menu");
        System.out.println("1. New Customer Registration");
        System.out.println("2. Login - Existing Customer");
        System.out.println("3. Admin Login");
        System.out.println("Enter your choice");
        int choice = scanner.nextInt();
        return choice;
    }

    private static Customer menuOperations(int mainMenuChoice, Login login, Customer customer, Scanner scanner) {
        switch (mainMenuChoice) {
            case 1:
                System.out.println("Enter Details To Open New Account");
                System.out.println("Enter first name");
                String firstName = scanner.next();
                System.out.println("Enter last name");
                String lastName = scanner.next();
                System.out.println("Enter gender");
                String gender = scanner.next();
                System.out.println("Enter email address");
                String email = scanner.next();
                System.out.println("Enter mobile number");
                String mobile = scanner.next();
                System.out.println("Enter your password");
                String password = scanner.next();

                if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() ||
                        gender == null || gender.isEmpty() || email == null || email.isEmpty() ||
                        mobile == null || mobile.isEmpty() || password == null || password.isEmpty()) {
                    System.out.println("Error: All fields are required.");
                    return null;
                }

                System.out.println("Choose account type (1. Savings, 2. Current)");
                int accountTypeChoice = scanner.nextInt();

                login = new Login(email, password); // Constructor should match
                customer = new Customer(firstName, lastName, gender, email, mobile, login, password);

                if (accountTypeChoice == 1) {
                    // Savings Account
                    customer.setAccount(new Savings(customer, "Savings"));
                    ((Savings) customer.getAccount()).setRateOfInterest(4.0); // Example interest rate
                    ((Savings) customer.getAccount()).setMinimumBalance(1000);
                } else if (accountTypeChoice == 2) {
                    // Current Account
                    customer.setAccount(new Current(customer, "Current"));
                    ((Current) customer.getAccount()).setOverdraftBalance(10000);
                    ((Current) customer.getAccount()).setRemainingOverdraftBalance(0);
                    ((Current) customer.getAccount()).setMinimumBalance(0);
                } else {
                    System.out.println("Invalid account type choice");
                    return null;
                }

                return customer;

            case 2:
                // No longer needed here
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
        return null;
    }

    private static Admin adminLogin(Scanner scanner) {
        System.out.println("Enter admin username");
        String username = scanner.next();
        System.out.println("Enter admin password");
        String password = scanner.next();

        Admin admin = new Admin(username, password);
        AdminService adminService = new AdminServiceImpl(new DatabaseUtilImpl());
        return adminService.validateAdminLogin(admin);
    }
    
}
