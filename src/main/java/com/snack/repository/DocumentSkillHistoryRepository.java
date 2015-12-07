package com.snack.repository;

import com.snack.domain.DocumentSkillHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSkillHistoryRepository extends JpaRepository<DocumentSkillHistory, Integer> {
}
