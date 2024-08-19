package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.service.AdminService;
import com.ofss.main.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("allusers")
	public List<Customer> getAllCustomer()
    {
    	return customerService.getAllCustomers();
    }
	
	@GetMapping("/unapprovedusers")
    public List<Customer> getUnapproved()
    {
		return adminService.getUnapprovedCustomers(false);
    }

	@GetMapping("/approvedusers")
	public List<Customer> getApproved()
	{
		return adminService.getUnapprovedCustomers(true);
	}
	
	@PutMapping("/updateCustomerStatus")
    public String updateCustomerStatus(@RequestParam String custId, @RequestParam boolean status) {
        adminService.updateCustomerStatus(custId, status);
        return "Customer status updated successfully!";
    }
	
	@PutMapping("/approve/{email}")
	public String updateLoginStatus(@PathVariable String email)
	{
		adminService.updateLoginStatus(email);
		return "user approved";
	}
}
