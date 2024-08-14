package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.CustomerRepository;

@Service
public interface CustomerService {

	Optional<Customer> getCustomerById(String custId);
	
	List<Customer> getAllCustomers();
	

	Customer addCustomer(Customer customer);
}
