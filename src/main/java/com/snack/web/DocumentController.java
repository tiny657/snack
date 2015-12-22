package com.snack.web;

import com.snack.domain.Comment;
import com.snack.domain.Document;
import com.snack.domain.Skill;
import com.snack.domain.User;
import com.snack.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class DocumentController {
	@Autowired
	private DocumentService documentService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserSkillService userSkillService;

	@Autowired
	private DocumentSkillService documentSkillService;

	@Autowired
	private SkillService skillService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Document> documents = documentService.findAll();
		for (Document document : documents) {
			document.htmlContent();
			document.displayRegDate();
			for(Comment comment : document.getComments()) {
				comment.displayRegDate();
			}
		}
		List<Skill> skills = skillService.findAll();
		model.addAttribute("documents", documents);
		model.addAttribute("skills", skills);
		return "list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Validated DocumentForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return list(model);
		}
		String[] skillNames = StringUtils.split(form.getSkill(), ",");

		Document document = new Document();
		BeanUtils.copyProperties(form, document);
		document.setRegDate(new Date());
		document.setEditDate(new Date());
		User author = userService.findOne(form.getUserId());
		document.setAuthor(author);
		Document managedDocument = documentService.create(document);

		for (String skillName : skillNames) {
			Skill managedSkill = skillService.findOne(skillName);

			if (managedSkill == null) {
				managedSkill = skillService.create(skillName);
				documentSkillService.create(managedDocument, managedSkill);
			} else {
				documentSkillService.create(managedDocument, managedSkill);
			}
			userSkillService.create(author, managedSkill);
		}
		return "redirect:/";
	}

//	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
//	public String editForm(@RequestParam Integer id, DocumentForm form) {
//		Document document = documentService.findOne(id);
//		BeanUtils.copyProperties(document, form);
//		return "edit";
//	}
//
//	@RequestMapping(value = "edit", method = RequestMethod.POST)
//	public String edit(@RequestParam Integer id, @Validated DocumentForm form,
//		BindingResult result) {
//		if (result.hasErrors()) {
//			return editForm(id, form);
//		}
//		Document document = new Document();
//		BeanUtils.copyProperties(form, document);
//		document.setId(id);
//		documentService.update(document);
//		return "redirect:/";
//	}

	@RequestMapping(value = "edit", params = "goToTop")
	public String goToTop() {
		return "redirect:/";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam Integer id) {
		documentService.delete(id);
		return "redirect:/";
	}
}
