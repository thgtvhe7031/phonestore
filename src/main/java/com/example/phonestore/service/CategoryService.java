/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.phonestore.service;

import com.example.phonestore.entity.Category;
import com.example.phonestore.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository cateRepo;
    
    public List<Category> getAllCategories() {
        
        List<Category> catelist = new ArrayList<Category>();
        
        cateRepo.findAll().forEach(Category -> catelist.add(Category));
        
        return catelist;
    
    }
    
}
