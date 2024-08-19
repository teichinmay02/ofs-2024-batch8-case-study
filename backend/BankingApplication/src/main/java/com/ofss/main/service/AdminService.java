package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Admin;
import com.ofss.main.domain.Customer;

@Service
public interface AdminService {
    Admin validateAdminLogin(Admin admin);
    boolean approveCustomer(int customerId);

	List<Customer> getAllCustomers();
	
	List<Customer> getUnapprovedCustomers(boolean status);
	
	public void updateCustomerStatus(String custId, boolean status);
	
	public void updateLoginStatus(String email);
}
