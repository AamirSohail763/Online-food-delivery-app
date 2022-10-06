package com.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Item;
import com.foodapp.repository.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDAO itemDAO;

	
	
	@Override
	public Item addItem(Item item) throws ItemException {
		Optional<Item> opt = itemDAO.findById(item.getItemId());
		if(opt.isPresent()) {
			throw new ItemException("Item already exists..");
		}else {
			return itemDAO.save(item);
		}
	}



	@Override
	public Item updateItem(Item item) throws ItemException {
		Optional<Item> opt = itemDAO.findById(item.getItemId());
		if(opt.isPresent()) {
			return itemDAO.save(item);
		}else {
			throw new ItemException("No such Item found..");
		}
	}



	@Override
	public Item viewItem(Integer itemId) throws ItemException {
		Optional<Item> opt = itemDAO.findById(itemId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}



	@Override
	public Item removeItem(Integer itemId) throws ItemException {
		Optional<Item> opt = itemDAO.findById(itemId);
		if(opt.isPresent()) {
			Item item = opt.get();
			itemDAO.delete(item);
			return item;
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}



	@Override
	public List<Item> viewAllItems() throws ItemException {
		List<Item> items = itemDAO.findAll();
		if(items.size() > 0) {
			return items;
		}else {
			throw new ItemException("No Item exists..");
		}
	}
	
	

}
