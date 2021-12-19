package com.example.phonestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phonestore.repository.BillRepository;

import com.example.phonestore.entity.Bill;

@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepo;
	
	public List<Bill> getBillsByCid(int cid) {
		return billRepo.findByCid(cid);
	}
	
	public List<Bill> getBillsByCidAndStatus(int cid,int status) {
		return billRepo.findByCidAndStatus(cid,status);
	}
	
	public void addBill(Bill bill) {
		billRepo.save(bill);
	}
	
	public int totalBillCount() {
		return (int) billRepo.count();
	}
	
}
