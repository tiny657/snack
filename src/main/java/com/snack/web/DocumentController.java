package com.snack.web;

import com.snack.domain.Document;
import com.snack.service.DocumentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class DocumentController {
	@Autowired
	private DocumentService documentService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Document> documents = documentService.findAll();
		model.addAttribute("documents", documents);
		return "list";
	}

	@RequestMapping(value = "new", params = "form", method = RequestMethod.GET)
	public String createForm(DocumentForm form) {
		return "edit";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String create(@Validated DocumentForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return list(model);
		}
		Document document = new Document();
		BeanUtils.copyProperties(form, document);
		documentService.create(document);
		return "redirect:/";
	}

	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
	public String editForm(@RequestParam Integer id, DocumentForm form) {
		Document document = documentService.findOne(id);
		BeanUtils.copyProperties(document, form);
		return "edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam Integer id, @Validated DocumentForm form,
		BindingResult result) {
		if (result.hasErrors()) {
			return editForm(id, form);
		}
		Document document = new Document();
		BeanUtils.copyProperties(form, document);
		document.setId(id);
		documentService.update(document);
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
