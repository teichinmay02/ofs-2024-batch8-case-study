package com.ofss.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;

@Service
public interface LoginService {
	public Login authenticateUser(String email, String password);
	public void incrementLoginCount(String email);
	Integer getLoginCount(String email);
	void lockAccount(String email);
}
