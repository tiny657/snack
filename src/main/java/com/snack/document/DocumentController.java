package com.snack.document;

import com.snack.document.meta.DocumentSkillService;
import com.snack.skill.Skill;
import com.snack.skill.SkillService;
import com.snack.social.FrontUserDetail;
import com.snack.user.User;
import com.snack.user.UserService;
import com.snack.user.UserSkillService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Slf4j
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
	private AttachedFileService attachedFileService;

	@Autowired
	private FileWriter fileWriter;

	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(required = false, defaultValue = "0") Integer from, @AuthenticationPrincipal FrontUserDetail frontUserDetail,
		Model model) {
		if (!ObjectUtils.isEmpty(frontUserDetail)) {
			User user = userService.findOne(frontUserDetail.getSocialUser().getEmail());
			model.addAttribute("imageUrl", user.getImageUrl());
			model.addAttribute("email", frontUserDetail.getUsername());
			model.addAttribute("name", frontUserDetail.getName());
		}

		Page<Document> documents = documentService.find(from);
		documents.forEach(Document::convertToDisplay);

		List<Skill> skills = skillService.findAll();
		model.addAttribute("documents", documents);
		model.addAttribute("skills", skills);
		model.addAttribute("oldest", from + 1);

		return "list";
	}

	@RequestMapping(value = "documents/{id}", method = RequestMethod.GET)
	public String document(@PathVariable Integer id, @AuthenticationPrincipal FrontUserDetail frontUserDetail,
		Model model) {
		if (!ObjectUtils.isEmpty(frontUserDetail)) {
			User user = userService.findOne(frontUserDetail.getSocialUser().getEmail());
			model.addAttribute("imageUrl", user.getImageUrl());
			model.addAttribute("email", frontUserDetail.getUsername());
			model.addAttribute("name", frontUserDetail.getName());
		}

		Document document = documentService.findOne(id);
		document.convertToDisplay();

		List<Skill> skills = skillService.findAll();
		model.addAttribute("document", document);
		model.addAttribute("skills", skills);

		return "document";
	}

	@RequestMapping(value = "more", method = RequestMethod.GET)
	public String more(@RequestParam(required = false, defaultValue = "0") Integer from, @AuthenticationPrincipal FrontUserDetail frontUserDetail,
		Model model) {
		Page<Document> documents = documentService.find(from);
		documents.forEach(Document::convertToDisplay);
		model.addAttribute("documents", documents);
		if (documents.getTotalPages() > from) {
			model.addAttribute("oldest", from + 1);
		}

		return "documents";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Validated DocumentForm form, BindingResult result, @AuthenticationPrincipal FrontUserDetail frontUserDetail) {
		if (result.hasErrors()) {
			log.info(result.toString());
			return "redirect:/";
		}
		if (frontUserDetail == null) {
			log.info("frontUserDetail is null. " + result.toString());
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

	@RequestMapping(value = "/attach", method = RequestMethod.POST)
	public ResponseEntity attach(MultipartHttpServletRequest request) {
		try {
			Iterator<String> iterator = request.getFileNames();

			while (iterator.hasNext()) {
				final String PATH = "attach";
				String uploadedFile = iterator.next();
				MultipartFile file = request.getFile(uploadedFile);
				AttachedFile dto = new AttachedFile();
				dto.setRegDate(new Date());
				dto.setFilename(file.getOriginalFilename());
				dto.setMimeType(file.getContentType());
				fileWriter.writeFile(file, PATH, dto.getFilename());
				attachedFileService.upload(dto);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("{}", HttpStatus.OK);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam Integer id) {
		documentService.delete(id);
		return "redirect:/";
	}

	@RequestMapping(value = "edit", params = "goToTop")
	public String goToTop() {
		return "redirect:/";
	}
}
