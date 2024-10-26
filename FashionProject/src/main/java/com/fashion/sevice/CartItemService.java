package com.fashion.sevice;

import java.util.List;

import com.fashion.model.CartItem;
import com.fashion.model.Category;

public interface CartItemService {
	CartItem findId(Integer id);
	Boolean add(CartItem cartItem);
	Boolean update(CartItem cartItem);
	Boolean delete(Integer id);
}
