package com.snack.repository;

import com.snack.domain.DocumentLiker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// TODO:: DocumentLikerId 맞나?
public interface DocumentLikerRepository extends JpaRepository<DocumentLiker, Integer> {
}

