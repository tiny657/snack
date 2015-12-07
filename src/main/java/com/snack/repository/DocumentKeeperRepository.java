package com.snack.repository;

import com.snack.domain.DocumentKeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentKeeperRepository extends JpaRepository<DocumentKeeper, Integer> {
}

