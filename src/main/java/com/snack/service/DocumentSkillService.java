package com.snack.service;

import com.snack.domain.Document;
import com.snack.domain.DocumentSkill;
import com.snack.domain.Skill;
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
	public DocumentSkill create(Document managedDocument, Skill managedSkill) {
		DocumentSkill documentSkill = new DocumentSkill();
		documentSkill.setDocument(managedDocument);
		documentSkill.setSkill(managedSkill);

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
