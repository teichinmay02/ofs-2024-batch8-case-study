package com.ofss.main.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Customer;
//import com.ofss.main.service.Impl.LoginServiceImpl;
import com.ofss.main.domain.Login;

@Repository
public interface LoginRepository extends CrudRepository<Customer, String> {
	 
	@Query("SELECT l FROM Login l WHERE l.email = :email")
	public Login findbyEmail(@Param("email") String email);

	void save(Login login);
	
//
//	@Modifying
//	@Query("UPDATE LOGIN l SET l.status=:status WHERE l.email=email")
//	void updateLoginStatus(@Param("email") String email, @Param("status") boolean status);
	
}