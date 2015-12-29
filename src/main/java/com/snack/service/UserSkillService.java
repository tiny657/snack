package com.snack.service;

import com.snack.domain.Skill;
import com.snack.domain.User;
import com.snack.domain.UserSkill;
import com.snack.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSkillService {
	@Autowired
	UserSkillRepository userSkillRepository;

	public List<UserSkill> findAll() {
		return userSkillRepository.findAll();
	}

	public UserSkill findOne(Integer id) {
		return userSkillRepository.findOne(id);
	}

	@Transactional
	public UserSkill create(User managedUser, Skill managedSkill) {
		UserSkill managedUserSkill = userSkillRepository.findByUserAndSkill(managedUser, managedSkill);
		if (managedUserSkill == null) {
			UserSkill userSkill = new UserSkill();
			userSkill.setUser(managedUser);
			userSkill.setSkill(managedSkill);
			userSkill.setSkillCount(1);
			userSkillRepository.save(userSkill);
		} else {
			managedUserSkill.increaseSkillCount();
		}
		return managedUserSkill;
	}

	public UserSkill update(UserSkill userSkill) {
		return userSkillRepository.save(userSkill);
	}

	public void delete(Integer id) {
		userSkillRepository.delete(id);
	}

	public void deleteAll() {
		userSkillRepository.deleteAll();
	}
}
