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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Item;
import com.foodapp.service.ItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/item")
public class ItemServiceController {
	
	@Autowired
	ItemService itemService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Item> addItem(@RequestBody Item item) throws ItemException{
		Item newItem = itemService.addItem(item);
		return new ResponseEntity<Item>(newItem, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ItemException{
		Item updatedItem = itemService.updateItem(item);
		return new ResponseEntity<Item>(updatedItem, HttpStatus.OK);
	}
	
	@GetMapping("/view/{itemId}")
	public ResponseEntity<Item> getItem(@PathVariable("itemId") Integer itemId) throws ItemException{
		Item item = itemService.viewItem(itemId);
		return new ResponseEntity<Item>(item, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{itemId}")
	public ResponseEntity<Item> removeItem(@PathVariable("itemId") Integer itemId) throws ItemException{
		Item removedItem = itemService.removeItem(itemId);
		return new ResponseEntity<Item>(removedItem, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/viewall")
	public ResponseEntity<List<Item>> getAllItems() throws ItemException{
		List<Item> items = itemService.viewAllItems();
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
		
	}
}
