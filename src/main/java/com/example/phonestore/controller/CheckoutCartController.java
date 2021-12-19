package com.example.phonestore.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.phonestore.entity.Bill;
import com.example.phonestore.entity.Cart;
import com.example.phonestore.entity.Customer;
import com.example.phonestore.entity.Product;
import com.example.phonestore.service.BillService;
import com.example.phonestore.service.ProductService;

@Controller
public class CheckoutCartController {
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductService proService;
	
	@Autowired
	private BillService billService;
	
	// this method will checkout from cart and add bill to database 
	@RequestMapping("/cart/checkout")
	public String checkout(@SessionAttribute Customer customer, @ModelAttribute Bill bill) {
		
		if(customer==null) {
			return "redirect:/login";
		}
		
		for (Product pro: new ArrayList<Product>(cart.getProductlist().values())) {
			
			//get product in storage
			Product p = proService.getProductByPid(pro.getPid()).get();
			
			//update new quantity
			p.setQuantity(p.getQuantity()-pro.getQuantity());
			
			proService.updateProduct(p);
			
		}
		
		bill.setOid((billService.totalBillCount()+1)+"");
		bill.setCid(customer.getCid());
		bill.setTotal(cart.getTotal());
		
		billService.addBill(bill);

		
		return "redirect:/profile";
	}
	
}
