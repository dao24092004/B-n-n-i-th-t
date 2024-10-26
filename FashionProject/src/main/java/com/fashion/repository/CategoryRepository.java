package com.fashion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fashion.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT c FROM Category c WHERE LOWER(TRANSLATE(c.name, 'ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúý', 'AAAAEEEIIOOOOUUYaaaaeeeiioooouuy')) LIKE LOWER(TRANSLATE(CONCAT('%', ?1, '%'), 'ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúý', 'AAAAEEEIIOOOOUUYaaaaeeeiioooouuy'))")
	List<Category> searchCategory(String keyWord);

}
