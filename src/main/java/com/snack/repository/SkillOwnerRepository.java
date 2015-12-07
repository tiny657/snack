package com.snack.repository;

import com.snack.domain.SkillOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillOwnerRepository extends JpaRepository<SkillOwner, Integer> {
}
