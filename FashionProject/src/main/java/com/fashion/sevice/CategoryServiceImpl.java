package com.fashion.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fashion.model.Category;
import com.fashion.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {

		return this.categoryRepository.findAll();
	}

	@Override
	public Boolean create(Category category) {
		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public Boolean update(Category category) {
		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;

	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.categoryRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public List<Category> searchCategory(String keyWord) {

		return this.categoryRepository.searchCategory(keyWord);
	}

	@Override
	public Page<Category> getAll(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 2);

		return this.categoryRepository.findAll(pageable);
	}

	@Override
	public Page<Category> searchCategory(String keyWord, Integer pageNo) {
		List lst = this.searchCategory(keyWord);
		Pageable pageable = PageRequest.of(pageNo - 1, 2);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > lst.size() ? lst.size()
				: pageable.getOffset() + pageable.getPageSize());
		lst = lst.subList(start, end);
		return new PageImpl<Category>(lst, pageable, this.searchCategory(keyWord).size());
	}

}
