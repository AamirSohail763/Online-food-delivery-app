package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.FoodCart;


@Repository
public interface FoodCartDAO extends JpaRepository<FoodCart, Integer>{

}
