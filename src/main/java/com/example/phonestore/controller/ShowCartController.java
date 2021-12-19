package com.example.phonestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.phonestore.entity.Cart;

@Controller
public class ShowCartController {
	
	@Autowired
	private Cart cart;
	
	@RequestMapping("/cart")
	public String showCart(Model model) {
		
		model.addAttribute("total", cart.getTotal());
		model.addAttribute("productlist", cart.getProductlist().values());
		return "cart";
		
	}
}
