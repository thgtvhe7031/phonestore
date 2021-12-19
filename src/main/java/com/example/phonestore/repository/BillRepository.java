/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.phonestore.repository;

import com.example.phonestore.entity.Bill;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface BillRepository extends CrudRepository<Bill, String > {
	
	public List<Bill> findByCid(int cid);
	
	public List<Bill> findByCidAndStatus(int cid, int status);
}
