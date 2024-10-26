package com.fashion.sevice;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fashion.model.Category;

public interface CategoryService {

	List<Category> getAll();
	Boolean create(Category category);
	Category findById(Integer id);
	Boolean update(Category category);
	Boolean delete(Integer id);
	List<Category> searchCategory(String keyWord);
	Page<Category> getAll(Integer pageNo);
	Page<Category> searchCategory(String keyWord, Integer pageNo);
}
