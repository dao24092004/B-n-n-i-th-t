package com.fashion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashion.model.Product;
import com.fashion.sevice.ProductService;

@Controller

public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public String home(Model model) {
		List<Product>  lstProducts = this.productService.getAll();
		model.addAttribute("product",lstProducts);
		
		List<Product> productNew = this.productService.getProductNew();
		model.addAttribute("productNew", productNew);
		return "client/index";
	}
	
}
