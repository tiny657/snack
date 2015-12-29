package com.snack.document.meta;

import com.snack.document.Document;
import com.snack.document.meta.DocumentSkill;
import com.snack.skill.Skill;
import com.snack.document.meta.DocumentSkillRepository;
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
