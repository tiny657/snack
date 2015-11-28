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

	public Document findOne(Integer id) {
		return documentRepository.findOne(id);
	}

	public Document create(Document document) {
		return documentRepository.save(document);
	}

	public Document update(Document document) {
		return documentRepository.save(document);
	}

	public void delete(Integer id) {
		documentRepository.delete(id);
	}
}
