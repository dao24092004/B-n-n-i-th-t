package com.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fashion.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);

}
