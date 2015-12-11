package com.snack.service;

import com.snack.domain.User;
import com.snack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User findOne(String userId) {
		return userRepository.findOne(userId);
	}
}
