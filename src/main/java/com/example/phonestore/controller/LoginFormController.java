package com.example.phonestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.phonestore.service.CustomerService;

@Controller
public class LoginFormController {
	
	@Autowired
	CustomerService customService;
		
	@RequestMapping(method=RequestMethod.GET,value="/login")
	public String login() {
		
		return "login";
	}
}
