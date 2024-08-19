package com.ofss.main.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.LoginRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Optional<Customer> getCustomerById(String custId) {
        return customerRepository.findById(custId);
    }

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		//return customerRepository.save(customer);
		
		Customer savedCustomer = customerRepository.save(customer);
		Login login = new Login();
		login.setEmail(customer.getEmail()); // Using email as username
        login.setPassword(customer.getFirstName()+"_"+customer.getCustId()); // Set a default or generated password
        login.setLoginCount(0);
        login.setStatus(false);
        login.setCustomer(customer);
        loginRepository.save(login);
        savedCustomer.setStatus(false);
		return savedCustomer;
	}

	
  
}
