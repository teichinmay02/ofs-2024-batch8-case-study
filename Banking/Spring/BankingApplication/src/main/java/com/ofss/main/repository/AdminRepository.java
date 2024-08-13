package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Customer;

@Repository
public interface AdminRepository extends CrudRepository<Customer, String> {
	List<Customer> findByStatus(boolean status);
}
