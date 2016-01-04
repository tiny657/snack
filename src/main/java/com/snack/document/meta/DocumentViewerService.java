package com.snack.document.meta;

import com.snack.document.meta.DocumentViewer;
import com.snack.document.meta.DocumentViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentViewerService {
	@Autowired
	private DocumentViewerRepository documentViewerRepository;

	public List<DocumentViewer> findAll() {
		return documentViewerRepository.findAll();
	}

	public DocumentViewer findOne(Integer id) {
		return documentViewerRepository.findOne(id);
	}

	@Transactional
	public DocumentViewer create(DocumentViewer documentViewer) {
		documentViewer.getDocument().increaseViewerCount();
		documentViewer.getViewer().increaseMyViewDocumentCount();
		return documentViewerRepository.save(documentViewer);
	}

	public DocumentViewer update(DocumentViewer documentViewer) {
		return documentViewerRepository.save(documentViewer);
	}

	public void delete(Integer id) {
		documentViewerRepository.delete(id);
	}

	public void deleteAll(){
		documentViewerRepository.deleteAll();
	}
}
