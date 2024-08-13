package com.ofss.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Customer;
//import com.ofss.main.service.Impl.LoginServiceImpl;
import com.ofss.main.domain.Login;

public interface LoginRepository extends CrudRepository<Customer, String> {

	Login findbyEmail(String email);

	void save(Login login);
	
}