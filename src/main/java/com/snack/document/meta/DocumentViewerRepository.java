package com.snack.document.meta;

import com.snack.document.meta.DocumentViewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentViewerRepository extends JpaRepository<DocumentViewer, Integer> {
}

