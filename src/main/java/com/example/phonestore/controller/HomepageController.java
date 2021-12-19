/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.phonestore.controller;

import com.example.phonestore.service.CategoryService;
import com.example.phonestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PC
 */
@Controller
public class HomepageController {
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService cateService;
    
    @RequestMapping(method=RequestMethod.GET, value="/")
    public String displayHomepage(Model model) {
        
        model.addAttribute("productlist", productService.getAllProducts());
        
        model.addAttribute("categorylist", cateService.getAllCategories());
        
        return "index";
    }
    
}
