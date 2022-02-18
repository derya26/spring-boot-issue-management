package com.derya.springboot.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.derya.springboot.entity.User;
import com.derya.springboot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements com.derya.springboot.service.UserService {
	
	private final UserRepository userRepository;

	@Override
	public User save(User user) {

		if(user.getEmail()==null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public User getById(Long id) {

		return userRepository.getOne(id);
	}

	@Override
	public Page<User> getAllPageable(Pageable pageable) {

		return userRepository.findAll(pageable);
	}

	@Override
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
