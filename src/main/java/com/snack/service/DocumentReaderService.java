package com.snack.service;

import com.snack.domain.DocumentReader;
import com.snack.repository.DocumentReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentReaderService {
	@Autowired
	DocumentReaderRepository documentReaderRepository;

	public List<DocumentReader> findAll() {
		return documentReaderRepository.findAll();
	}

	public DocumentReader findOne(Integer id) {
		return documentReaderRepository.findOne(id);
	}

	@Transactional
	public DocumentReader create(DocumentReader documentReader) {
		documentReader.getDocument().increaseReaderCount();
		documentReader.getReader().increaseMyReadDocumentCount();
		return documentReaderRepository.save(documentReader);
	}

	public DocumentReader update(DocumentReader documentReader) {
		return documentReaderRepository.save(documentReader);
	}

	public void delete(Integer id) {
		documentReaderRepository.delete(id);
	}

	public void deleteAll(){
		documentReaderRepository.deleteAll();
	}
}
