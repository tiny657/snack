package com.snack.document.meta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentSharerRepository extends JpaRepository<DocumentSharer, Integer> {
}

