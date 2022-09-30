package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Restaurant;


@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Integer>{

}
