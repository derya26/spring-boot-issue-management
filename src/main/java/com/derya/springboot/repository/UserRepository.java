package com.derya.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.derya.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
