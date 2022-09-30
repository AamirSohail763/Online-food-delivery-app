package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.OrderDetails;


@Repository
public interface OrderDAO extends JpaRepository<OrderDetails, Integer>{

}
