package com.snack.document;

import com.snack.document.meta.DocumentSkillService;
import com.snack.skill.Skill;
import com.snack.skill.SkillService;
import com.snack.social.ConnectionService;
import com.snack.social.FrontUserDetail;
import com.snack.user.User;
import com.snack.user.UserService;
import com.snack.user.UserSkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
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

	@Autowired
	private ConnectionService connectionService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(@AuthenticationPrincipal FrontUserDetail frontUserDetail, Model model) {
		if (!ObjectUtils.isEmpty(frontUserDetail)) {
			User user = userService.findOne(frontUserDetail.getSocialUser().getEmail());
			model.addAttribute("imageUrl", user.getImageUrl());
			model.addAttribute("email", frontUserDetail.getUsername());
			model.addAttribute("name", frontUserDetail.getName());
		}

		List<Document> documents = documentService.findAll();
		documents.forEach(Document::convertToDisplay);

		List<Skill> skills = skillService.findAll();
		model.addAttribute("documents", documents);
		model.addAttribute("skills", skills);

		return "list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Validated DocumentForm form, BindingResult result, @AuthenticationPrincipal FrontUserDetail frontUserDetail, Model model) {
		if (result.hasErrors()) {
			// TODO:: error popup
			return "redirect:/";
		}
		if (frontUserDetail == null) {
			// TODO:: error popup
			return "redirect:/";
		}

		String[] skillNames = StringUtils.split(form.getSkill(), ",");

		Document document = new Document();
		BeanUtils.copyProperties(form, document);
		document.setRegDate(new Date());
		document.setEditDate(new Date());
		User author = userService.findOne(frontUserDetail.getUsername());
		document.setAuthor(author);
		Document managedDocument = documentService.create(document);

		for (String skillName : skillNames) {
			Skill managedSkill = skillService.findOne(skillName);

			if (managedSkill == null) {
				managedSkill = skillService.create(skillName);
			}
			documentSkillService.create(managedDocument, managedSkill);
			userSkillService.create(author, managedSkill);
		}
		return "redirect:/";
	}

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
