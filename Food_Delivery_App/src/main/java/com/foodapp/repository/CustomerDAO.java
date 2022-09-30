package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Customer;


@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
