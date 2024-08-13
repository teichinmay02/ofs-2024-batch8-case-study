package com.ofss.main.service;

import com.ofss.main.domain.Admin;
import com.ofss.main.domain.Customer;
import com.ofss.main.repository.AdminRepository;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.service.AdminService;
import com.ofss.main.service.DatabaseUtil;

import jakarta.transaction.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Admin validateAdminLogin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveCustomer(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public List<Customer> getUnapprovedCustomers(boolean status) {
		// TODO Auto-generated method stub
		return adminRepository.findByStatus(status);
	}

	@Transactional
	@Override
	public void updateCustomerStatus(String custId, boolean status) {
		customerRepository.updateCustomerStatus(custId, status);
		// TODO Auto-generated method stub
		
	}
	
	
}
