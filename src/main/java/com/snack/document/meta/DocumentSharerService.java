package com.snack.document.meta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentSharerService {
	@Autowired
	private DocumentSharerRepository documentSharerRepository;

	public List<DocumentSharer> findAll() {
		return documentSharerRepository.findAll();
	}

	public DocumentSharer findOne(Integer id) {
		return documentSharerRepository.findOne(id);
	}

	@Transactional
	public DocumentSharer create(DocumentSharer documentSharer) {
		documentSharer.getDocument().increaseShareCount();
		documentSharer.getSharer().increaseMyShareCount();
		return documentSharerRepository.save(documentSharer);
	}

	public DocumentSharer update(DocumentSharer documentSharer) {
		return documentSharerRepository.save(documentSharer);
	}

	public void delete(Integer id) {
		documentSharerRepository.delete(id);
	}

	public void deleteAll() {
		documentSharerRepository.deleteAll();
	}
}
