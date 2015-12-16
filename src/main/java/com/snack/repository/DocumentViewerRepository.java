package com.snack.repository;

import com.snack.domain.DocumentViewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentViewerRepository extends JpaRepository<DocumentViewer, Integer> {
}
