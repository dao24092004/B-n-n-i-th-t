package com.fashion.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.model.CartItem;
import com.fashion.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemRepository cartItemRepository;
	@Override
	public CartItem findId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(CartItem cartItem) {
		try {
			this.cartItemRepository.save(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean update(CartItem cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
