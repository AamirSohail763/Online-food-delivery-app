package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Item;

public interface ItemService {
	
	public Item addItem(Item item)throws ItemException;
	
	public Item updateItem(Item item)throws ItemException;
	
	public Item viewItem(Integer itemId)throws ItemException;
	
	public Item removeItem(Integer itemId)throws ItemException;
	
	public List<Item> viewAllItems()throws ItemException;

}
