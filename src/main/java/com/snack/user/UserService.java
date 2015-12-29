package com.snack.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(String userId) {
		return userRepository.findOne(userId);
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void delete(String userId) {
		userRepository.delete(userId);
	}

	public void deleteAll(){
		userRepository.deleteAll();
	}
}
