package com.fashion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/cart")
public class CartController {
	 private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping("")
    public String view() {
    	
    	System.out.println("helol");
        return "client/cart/index";
    }

    @PostMapping("/add-cart")
    public String addToCart(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
        System.out.println("Product ID: " + id + ", Quantity: " + quantity);
        // Có thể thêm logic để xử lý giỏ hàng ở đây

        // Redirect lại về trang giỏ hàng hoặc trang khác sau khi thêm
        return "redirect:/detail"; // Hoặc chuyển hướng đến một view khác
    }
}
