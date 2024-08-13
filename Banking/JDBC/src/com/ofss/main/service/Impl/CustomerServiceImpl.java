package com.ofss.main.service.Impl;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.Impl.CustomerRepositoryImpl;
import com.ofss.main.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        this.customerRepository = new CustomerRepositoryImpl();
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

     @Override
    public Customer addNewCustomer(Customer customer) {
        // Call the repository method which now returns a Customer object
        Customer createdCustomer = customerRepository.addNewCustomer(customer);
        return createdCustomer;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        // Implement this method if needed
        return null;
    }

}