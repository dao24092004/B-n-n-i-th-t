package com.fashion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fashion.model.CartItem;
import com.fashion.model.Category;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	

}
