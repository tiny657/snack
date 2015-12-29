package com.snack.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	List<Skill> findByOrderByDocumentCountDesc();
	Skill findByName(String name);
}
