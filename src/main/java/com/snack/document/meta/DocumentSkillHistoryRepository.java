package com.snack.document.meta;

import com.snack.document.meta.DocumentSkillHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSkillHistoryRepository extends JpaRepository<DocumentSkillHistory, Integer> {
}
