package com.snack.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	private static final int SIZE = 2;

	public Page<Document> find(int from) {
		Pageable pageable = new PageRequest(from, SIZE, Sort.Direction.DESC, "id");
		return documentRepository.findAll(pageable);
	}

	public Document findOne(Integer id) {
		return documentRepository.findOne(id);
	}

	public Document create(Document document) {
		document.getAuthor().increaseMyDocumentCount();
		return documentRepository.save(document);
	}

	public Document update(Document document) {
		return documentRepository.save(document);
	}

	public void delete(Integer id) {
		documentRepository.delete(id);
	}

	public void deleteAll() {
		documentRepository.deleteAll();
	}

	public int size() {
		return SIZE;
	}
}
