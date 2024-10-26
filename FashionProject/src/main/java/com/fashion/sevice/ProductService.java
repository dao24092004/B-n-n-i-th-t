package com.fashion.sevice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fashion.model.Category;
import com.fashion.model.Product;

public interface ProductService {

	List<Product> getAll();
	Boolean create(Product product);
	Product findById(Integer id);
	Boolean update(Product product);
	Boolean delete(Integer id);
	List<Product> getProductNew();
}
