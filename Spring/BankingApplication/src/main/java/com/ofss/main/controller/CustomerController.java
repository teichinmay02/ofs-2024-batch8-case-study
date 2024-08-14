package com.ofss.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController 
{
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable String id) 
    {
    	 return customerService.getCustomerById(id);
    }
    
    @GetMapping()
    public List<Customer> getAllCustomer()
    {
    	return customerService.getAllCustomers();
    }
    
    @PostMapping("adddata")
    public Customer addCustomer(@RequestBody Customer customer)
    {
    	customer.setStatus(false);
    	return customerService.addCustomer(customer);
    }
}
