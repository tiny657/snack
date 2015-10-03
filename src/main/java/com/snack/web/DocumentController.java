package com.snack.web;

import com.snack.domain.Document;
import com.snack.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/doc")
public class DocumentController {
	@Autowired
	DocumentService documentService;

	@ModelAttribute CustomerForm setUpForm() {
		return new CustomerForm();
	}

	@RequestMapping(method = RequestMethod.GET) String list(Model model) {
		List<Document> documents = documentService.findAll();
		model.addAttribute("customers", documents);
		return "list";
	}
}
