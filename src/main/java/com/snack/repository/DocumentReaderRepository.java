package com.snack.repository;

import com.snack.domain.DocumentReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentReaderRepository extends JpaRepository<DocumentReader, Integer> {
}

