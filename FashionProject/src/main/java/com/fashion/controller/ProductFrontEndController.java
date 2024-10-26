package com.fashion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashion.model.ImageProduct;
import com.fashion.model.Product;
import com.fashion.sevice.ProductService;

@Controller
@RequestMapping("/")
public class ProductFrontEndController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("detail/{id}")
	public String detail(@PathVariable("id")Integer id, Model model){
		
		Product product = this.productService.findById(id);
		model.addAttribute("product", product);
		
		List<String> imgDetail = new ArrayList<>();
		for (ImageProduct imgPro : product.getImageProducts()) {
			imgDetail.add(imgPro.getImage());
		}
		model.addAttribute("imgDetail",imgDetail);
		return"client/detail";
		
	}
}
