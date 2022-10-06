package com.foodapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.FoodCart;
import com.foodapp.model.Item;
import com.foodapp.repository.FoodCartDAO;
import com.foodapp.repository.ItemDAO;

@Service
public class FoodCartServiceImpl implements FoodCartService{
	
	@Autowired
	FoodCartDAO cartDAO;

	@Autowired
	ItemDAO itemDAO;
	
	
	@Override
	public FoodCart saveCart(FoodCart cart) throws CartException {
		Optional<FoodCart> opt = cartDAO.findById(cart.getCartId());
		if(opt.isPresent()) {
			throw new CartException("Cart already exists..");
		}else {
			 return cartDAO.save(cart);
		}
	}


	@Override
	public FoodCart clearCart(Integer cartId) throws CartException {
		Optional<FoodCart> opt = cartDAO.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			cartDAO.delete(cart);
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}


	@Override
	public FoodCart viewCart(Integer cartId) throws CartException {
		Optional<FoodCart> opt = cartDAO.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}


	@Override
	public FoodCart addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
		Optional<FoodCart> cOpt = cartDAO.findById(cartId);
		if(cOpt.isPresent()) {
			
			Optional<Item> iOpt = itemDAO.findById(itemId);
			if(iOpt.isPresent()) {
				
				FoodCart cart = cOpt.get();
				Item item = iOpt.get();
				List<Item> list = new ArrayList<>();
				list.addAll(cart.getItemList());
				list.add(item);
				cart.setItemList(list);
				
				return cart;
				
			}else {
				throw new ItemException("No Item found with ID: "+itemId);
			}
			
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}




}
