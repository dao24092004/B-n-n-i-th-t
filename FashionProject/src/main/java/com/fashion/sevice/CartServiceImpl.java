package com.fashion.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.model.Cart;
import com.fashion.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository ;
	
	@Override
	public Boolean addCart(Cart cart) {
		try {
			 this.cartRepository.save(cart);
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
