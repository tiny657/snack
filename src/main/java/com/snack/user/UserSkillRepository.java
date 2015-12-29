package com.snack.user;

import com.snack.skill.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
	UserSkill findByUserAndSkill(User managedUser, Skill managedSkill);
}
