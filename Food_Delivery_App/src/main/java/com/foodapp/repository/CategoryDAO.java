package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
