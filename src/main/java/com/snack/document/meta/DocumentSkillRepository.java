package com.snack.document.meta;

import com.snack.document.meta.DocumentSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSkillRepository extends JpaRepository<DocumentSkill, Integer> {
}
