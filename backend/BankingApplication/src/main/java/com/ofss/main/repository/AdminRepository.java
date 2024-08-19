package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Customer;

@Repository
public interface AdminRepository extends CrudRepository<Customer, String> {
	List<Customer> findByStatus(boolean status);

	@Modifying
	@Query("UPDATE Login l SET l.status=false, l.loginCount = 0 WHERE l.email=email")
	void updateLoginStatus(String email);
	
}
