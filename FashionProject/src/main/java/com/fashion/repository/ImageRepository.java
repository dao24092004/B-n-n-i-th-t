package com.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fashion.model.ImageProduct;

import jakarta.transaction.Transactional;

@Transactional
public interface ImageRepository extends JpaRepository<ImageProduct, Integer> {
	// Corrected repository query
	@Modifying
	@Query("DELETE FROM ImageProduct i WHERE i.product.id=?1")

	void deleteByProductId( Integer idProduct);
}
