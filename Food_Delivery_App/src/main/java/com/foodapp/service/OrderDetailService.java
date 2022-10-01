package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.exceptions.OrderException;
import com.foodapp.model.OrderDetails;

public interface OrderDetailService {
	
	public OrderDetails addOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails updateOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails removeOrder(Integer orderId)throws OrderException;
	
	public OrderDetails viewOrder(Integer orderId)throws OrderException;
	
	public List<OrderDetails> viewAllOrdersByCustomer(Integer customerId)throws OrderException,CustomerException;

}
