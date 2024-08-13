package com.ofss.main.repository;

import com.ofss.main.domain.Customer;
import com.ofss.main.service.Impl.LoginServiceImpl;

public interface CustomerRepository {
    Customer addNewCustomer(Customer customer);
    
    Customer getCustomerById(int customerId);

    boolean validateCustomerLogin(int loginId, String password);

    default boolean login(int loginId, String passwor) {
        System.out.println("Attempting login for ID: " + loginId);
        return validateCustomerLogin(loginId, LoginServiceImpl.password);
    }
}