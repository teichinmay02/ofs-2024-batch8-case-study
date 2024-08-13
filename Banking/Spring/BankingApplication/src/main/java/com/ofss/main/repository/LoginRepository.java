package com.ofss.main.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.main.domain.Customer;
//import com.ofss.main.service.Impl.LoginServiceImpl;
import com.ofss.main.domain.Login;

public interface LoginRepository extends CrudRepository<Customer, String> {
	 
	@Query("SELECT l FROM Login l WHERE l.email = :email")
	public Login findbyEmail(@Param("email") String email);

	void save(Login login);
	
}