/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.phonestore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.phonestore.entity.Customer;
import com.example.phonestore.repository.CustomerRepository;

/**
 *
 * @author PC
 */
@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customRepo;
    
    public Customer getCustomer(String username, String password) {
	   
	   return customRepo.findByUsernameAndPassword(username,password);
	   
   }
    
}
