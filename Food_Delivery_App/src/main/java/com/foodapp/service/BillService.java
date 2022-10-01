package com.foodapp.service;

import com.foodapp.exceptions.BillException;
import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Bill;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	
	public Bill updateBill(Bill bill)throws BillException;
	
	public Bill removeBill(Bill bill)throws BillException;
	
	public Bill viewBill(Integer billId)throws BillException;
	
	public String generateBillById(Integer customerId)throws BillException,CustomerException;
	

}
