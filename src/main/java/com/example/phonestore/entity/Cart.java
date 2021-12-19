package com.example.phonestore.entity;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Cart {
	
	// key: product id
	// value: product information
	private HashMap<Integer,Product> productlist;

	private double total ;
	
	public Cart() {
		productlist = new HashMap<>();
		total = 0;
	}
	
	public double getTotal() {
				
		total = 0;
		
		for (Product pro: productlist.values()) {
			total += pro.getPrice()*pro.getQuantity();
		}
		
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public HashMap<Integer, Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(HashMap<Integer, Product> productlist) {
		this.productlist = productlist;
	}
	
}
