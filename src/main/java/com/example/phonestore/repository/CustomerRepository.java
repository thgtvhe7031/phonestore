package com.example.phonestore.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.phonestore.entity.Customer;

/**
*
* @author PC
*/
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
   
	public Customer findByUsernameAndPassword(String username, String password);
}
