package com.ofss.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;

@Service
public interface LoginService {
	 Login authenticateUser(String email, String password);
	 void incrementLoginCount(String email);
}
