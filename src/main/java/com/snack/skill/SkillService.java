package com.snack.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillService {
	@Autowired
	SkillRepository skillRepository;

	public List<Skill> findAll() {
		return skillRepository.findByOrderByDocumentCountDesc();
	}

	public Skill findOne(Integer id) {
		return skillRepository.findOne(id);
	}

	public Skill findOne(String name) {
		return skillRepository.findByName(name);
	}

	public Skill create(String skillName) {
		Skill skill = new Skill();
		skill.setName(skillName);
		return skillRepository.save(skill);
	}

	public Skill update(Skill skill) {
		return skillRepository.save(skill);
	}

	public void delete(Integer id) {
		skillRepository.delete(id);
	}

	public void deleteAll() {
		skillRepository.deleteAll();
	}
}
