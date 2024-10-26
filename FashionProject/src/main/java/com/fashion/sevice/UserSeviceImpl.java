package com.fashion.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.model.User;
import com.fashion.repository.UserRepository;

@Service
public class UserSeviceImpl implements UserSevice{

	@Autowired
	private UserRepository userRepository;
	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

}
