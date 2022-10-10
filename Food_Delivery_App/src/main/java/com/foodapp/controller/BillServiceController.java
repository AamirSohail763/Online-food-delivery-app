package com.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.BillException;
import com.foodapp.exceptions.CustomerException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Bill;
import com.foodapp.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillServiceController {
	
	@Autowired
	BillService billService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Bill> generateBill(@RequestBody Bill bill) throws BillException {
		Bill myBill = billService.addBill(bill);
		return new ResponseEntity<Bill>(myBill, HttpStatus.CREATED);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) throws BillException {
		Bill myBill = billService.updateBill(bill);
		return new ResponseEntity<Bill>(myBill, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/remove/{billId}")
	public ResponseEntity<Bill> removeBill(@PathVariable("billId") Integer billId ) throws BillException{
		Bill removedBill = billService.removeBill(billId);
		return new ResponseEntity<Bill>(removedBill, HttpStatus.OK);
	}
	
	@GetMapping("/view/{billId}")
	public ResponseEntity<Bill> viewBill(@PathVariable("billId") Integer billId) throws BillException{
		Bill bill = billService.viewBill(billId);
		return new ResponseEntity<Bill>(bill, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/viewtotal/{customerId}")
	public ResponseEntity<String> getTotalByCustomerId(@PathVariable("customerId") Integer customerId) throws ItemException, CustomerException{
		String total = billService.generateTotalBillById(customerId);
		return new ResponseEntity<String>(total, HttpStatus.OK);
	}

}
