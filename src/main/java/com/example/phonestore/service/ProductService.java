/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.phonestore.service;

import com.example.phonestore.entity.Product;
import com.example.phonestore.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepo;
    
    public List<Product> getAllProducts() {
        
        List<Product> productlist = new ArrayList<Product>();
        
        productRepo.findAll().forEach(product -> productlist.add(product));
        
        return productlist;
    
        
        
    }
    
    public Optional<Product> getProductByPid(String pid) {
    	return productRepo.findById(pid);
    }
    
    public void updateProduct(Product pro) {
    	productRepo.save(pro);
    }
}
