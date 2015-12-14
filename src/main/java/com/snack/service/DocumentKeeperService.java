package com.snack.service;

import com.snack.domain.DocumentKeeper;
import com.snack.repository.DocumentKeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentKeeperService {
	@Autowired
	DocumentKeeperRepository documentKeeperRepository;

	public List<DocumentKeeper> findAll() {
		return documentKeeperRepository.findAll();
	}

	public DocumentKeeper findOne(Integer id) {
		return documentKeeperRepository.findOne(id);
	}

	@Transactional
	public DocumentKeeper create(DocumentKeeper documentKeeper) {
		documentKeeper.getDocument().increaseKeeperCount();
		documentKeeper.getKeeper().increaseMyKeepCount();
		return documentKeeperRepository.save(documentKeeper);
	}

	public DocumentKeeper update(DocumentKeeper documentKeeper) {
		return documentKeeperRepository.save(documentKeeper);
	}

	public void delete(Integer id) {
		documentKeeperRepository.delete(id);
	}

	public void deleteAll() {
		documentKeeperRepository.deleteAll();
	}
}
