package com.snack.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillOwnerHistoryRepository extends JpaRepository<SkillOwnerHistory, Integer> {
}
