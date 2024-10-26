package com.fashion.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fashion.model.Category;
import com.fashion.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p  where p.status =true ORDER BY p.id DESC")
	List<Product> getProductNew(Pageable pageable);
	


}
