package com.example.phonestore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.phonestore.entity.Cart;
import com.example.phonestore.entity.Customer;
import com.example.phonestore.entity.Product;
import com.example.phonestore.service.ProductService;

@Controller
public class AddToCartController {

	@Autowired
	private Cart cart;
		
	@Autowired
	ProductService proService;
	
	// add to cart with id of product
	@RequestMapping("/cart/add")
	public String addToCart(@SessionAttribute Optional<Customer> customer, @RequestParam Optional<String> pid) {
		
		// check if user logged in
		if(!customer.isPresent()) {
			return "redirect:/login";
		}
		
		if(pid.isPresent()) {
			
			Product productinfo = proService.getProductByPid(pid.get()).get();
			
			if(productinfo.getQuantity()>0) { 
				
				int pidInteger = Integer.parseInt(pid.get());
				
				
				try {
					// there is already product in cart. add 1 to quantity
					Product product = cart.getProductlist().get(pidInteger);
					
					cart.getProductlist().get(pidInteger).setQuantity(product.getQuantity()+1);
					
				} catch(NullPointerException e) {
					// add the new product to cart with quantity 1
					productinfo.setQuantity(1);
					cart.getProductlist().put(pidInteger, productinfo);
					
				}
				
			}
			
		} 
		
		return "redirect:/cart";
	}
}
