package com.example.phonestore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.phonestore.entity.Bill;
import com.example.phonestore.entity.Customer;
import com.example.phonestore.service.BillService;

@Controller
public class UserProfileController {
	
	@Autowired
	private BillService billService;
	
	// view profile of user (include personal infor and user bill list)
	@RequestMapping("/profile")
	public String userProfile(@SessionAttribute Optional<Customer> customer,Model model) {
		
		// if user not log in
		if(!customer.isPresent()) {
			return "redirect:/login";
		}
		
		// get bill of user
		int cid = customer.get().getCid();
		List<Bill> bills = new ArrayList<>();
		
		bills.addAll(billService.getBillsByCidAndStatus(cid, 0));
		bills.addAll(billService.getBillsByCidAndStatus(cid, 1));
		bills.addAll(billService.getBillsByCidAndStatus(cid, 2));
		bills.addAll(billService.getBillsByCidAndStatus(cid, 3));
		bills.addAll(billService.getBillsByCidAndStatus(cid, 4));
		
		model.addAttribute("bills", bills);
		
		return "profile";
		
	}
	
}
