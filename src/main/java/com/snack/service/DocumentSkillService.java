package com.snack.service;

import com.snack.domain.DocumentSkill;
import com.snack.repository.DocumentSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentSkillService {
	@Autowired
	DocumentSkillRepository documentSkillRepository;

	public List<DocumentSkill> findAll() {
		return documentSkillRepository.findAll();
	}

	public DocumentSkill findOne(Integer id) {
		return documentSkillRepository.findOne(id);
	}

	@Transactional
	public DocumentSkill create(DocumentSkill documentSkill) {
		documentSkill.getDocument().increaseSkillCount();
		documentSkill.getSkill().increaseDocumentCount();
		return documentSkillRepository.save(documentSkill);
	}

	public DocumentSkill update(DocumentSkill documentSkill) {
		return documentSkillRepository.save(documentSkill);
	}

	public void delete(Integer id) {
		documentSkillRepository.delete(id);
	}

	public void deleteAll() {
		documentSkillRepository.deleteAll();
	}
}
