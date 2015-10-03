package com.snack.service;

import com.snack.domain.Document;
import com.snack.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public List<Document> findAll() {
        return documentRepository.findAll();
    }
}
