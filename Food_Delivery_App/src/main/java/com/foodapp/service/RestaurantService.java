package com.foodapp.service;

import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant removeRestaurant(Integer restaurantId)throws RestaurantException;
	
	public Restaurant viewRestaurant(Integer restaurantId)throws RestaurantException;
	
	

}
