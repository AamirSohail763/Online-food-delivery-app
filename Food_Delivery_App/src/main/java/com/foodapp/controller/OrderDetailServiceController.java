package com.foodapp.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.authexceptions.AuthorizationException;
import com.foodapp.authservice.UserSessionService;
//import com.foodapp.authexceptions.AuthorizationException;
//import com.foodapp.authservice.UserSessionService;
import com.foodapp.exceptions.CustomerException;
import com.foodapp.exceptions.OrderException;
import com.foodapp.model.Item;
import com.foodapp.model.OrderDetails;
import com.foodapp.service.OrderDetailService;

@RestController
@RequestMapping("/order")
public class OrderDetailServiceController {
	
	@Autowired
	OrderDetailService orderService;
	
	@Autowired
	UserSessionService userSessionService;
	
	
	
	 @PostMapping("/save")
     public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails order, @RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<OrderDetails>(orderService.addOrder(order), HttpStatus.CREATED);
     	else
     		throw new OrderException();
     }
	 
	 
	 @PutMapping("/update")
     public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order, @RequestParam String key) throws OrderException, AuthorizationException{
         
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<OrderDetails>(orderService.updateOrder(order), HttpStatus.ACCEPTED);
     	else
     		throw new OrderException();
     		
     }
	 
	 
	 @DeleteMapping("/remove/{orderId}")
     public ResponseEntity<OrderDetails> deleteOrder(@PathVariable("orderId") Integer orderId , @RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null) 
     		return new ResponseEntity<OrderDetails>(orderService.removeOrder(orderId), HttpStatus.ACCEPTED);
     	
     	else
     		throw new OrderException();
     }
	 
	 @GetMapping("/view/{orderId}")
     public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId,@RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return  new ResponseEntity<OrderDetails>(orderService.viewOrder(orderId),HttpStatus.FOUND);
     	else
     		throw new OrderException();
     }
	 
	 
	 @GetMapping("/viewbycustomer/{customerId}")
     public ResponseEntity<List<Item>> viewAllOrders(@PathVariable("customerId") Integer customerId,@RequestParam String key) throws OrderException, CustomerException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return  new ResponseEntity<List<Item>>(orderService.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);
     	else
     		throw new OrderException();
     }

}
