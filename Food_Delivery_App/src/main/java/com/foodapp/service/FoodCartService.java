package com.foodapp.service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.FoodCart;

public interface FoodCartService {
	
	public FoodCart saveCart(FoodCart cart)throws CartException;
	
	public FoodCart addItem(Integer cartId, Integer itemId)throws CartException,ItemException;
	
	public FoodCart clearCart(Integer cartId)throws CartException;
	
	public FoodCart viewCart(Integer cartId)throws CartException;

}
