package com.example.phonestore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.phonestore.entity.Customer;
import com.example.phonestore.service.CustomerService;

@Controller
@SessionAttributes("customer")
public class LoginController {
	
	@Autowired
	CustomerService customService;
	
	// get username and password to log in
//	@ModelAttribute("customer")
//	public Customer getCustomer(@RequestParam String username, @RequestParam String password) {
//
//			Customer c = customService.getCustomer(username, password);
//			return c;
//	}
//	
//	@RequestMapping(method=RequestMethod.POST,value="/login")
//	public String submitLoginForm(@SessionAttribute(required=false) Customer customer, Model model) {
//		
//		if(customer != null) {
//			// login successfully
//			return "redirect:/";
//		} else {
//			// login unsuccessfully
//			model.addAttribute("message","wrong username or password");
//			return "error";
//		}
//	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
    public String submitLoginForm(@RequestParam String username, @RequestParam String password, Model model) {
        Customer customer = customService.getCustomer(username, password);
        if(customer != null) {
            // login successfully
        	
            model.addAttribute("customer", customer); // !!
            return "redirect:/";
        } else {
        	
            // login unsuccessfully
            model.addAttribute("message","wrong username or password");
            return "error";
        }
    }

}
