package com.ofss.main.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.main.domain.Customer;
//import com.ofss.main.service.Impl.LoginServiceImpl;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Modifying
    @Query("UPDATE Customer c SET c.status = :status WHERE c.custId = :custId")
    void updateCustomerStatus(@Param("custId") String custId, @Param("status") boolean status);
}