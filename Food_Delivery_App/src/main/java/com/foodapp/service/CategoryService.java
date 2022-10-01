package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.CategoryException;
import com.foodapp.model.Category;

public interface CategoryService {
	
	
	public Category addCategory(Category category)throws CategoryException;
	
	public Category updateCategory(Category category)throws CategoryException;
	
	public Category viewCategory(Integer categoryId)throws CategoryException;
	
	public Category removeCategory(Integer categoryId)throws CategoryException;
	
	public List<Category> viewAllCategory()throws CategoryException;

}
