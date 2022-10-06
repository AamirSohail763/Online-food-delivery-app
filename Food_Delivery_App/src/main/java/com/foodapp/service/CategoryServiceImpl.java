package com.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.CategoryException;
import com.foodapp.model.Category;
import com.foodapp.repository.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDAO categoryDAO;

	
	
	
	@Override
	public Category addCategory(Category category) throws CategoryException {
		Optional<Category> opt = categoryDAO.findById(category.getCategoryId());
		if(opt.isPresent()) {
			throw new CategoryException("Category already exists..");
		}else {
			return categoryDAO.save(category);
		}
	}



	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Optional<Category> opt = categoryDAO.findById(category.getCategoryId());
		if(opt.isPresent()) {
			return categoryDAO.save(category);
		}else {
			throw new CategoryException("No such category found..");
		}
	}



	@Override
	public Category viewCategory(Integer categoryId) throws CategoryException {
		Optional<Category> opt = categoryDAO.findById(categoryId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new CategoryException("No Category found with ID: "+categoryId);
		}
	}



	@Override
	public Category removeCategory(Integer categoryId) throws CategoryException {
		Optional<Category> opt = categoryDAO.findById(categoryId);
		if(opt.isPresent()) {
			Category cat = opt.get();
			categoryDAO.delete(cat);
			return cat;
		}else {
			throw new CategoryException("No Category found with ID: "+categoryId);
		}
	}



	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		List<Category> categories = categoryDAO.findAll();
		if(categories.size() > 0) {
			return categories;
		}else {
			throw new CategoryException("No Categories exists..");
		}
	}
	
	
	

}
