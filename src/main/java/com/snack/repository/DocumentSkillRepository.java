package com.snack.repository;

import com.snack.domain.DocumentSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSkillRepository extends JpaRepository<DocumentSkill, Integer> {
}
