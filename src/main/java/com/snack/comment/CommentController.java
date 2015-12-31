package com.snack.comment;

import com.snack.document.Document;
import com.snack.document.DocumentService;
import com.snack.user.User;
import com.snack.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private DocumentService documentService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Comment> comments = commentService.findAll();
		model.addAttribute("comments", comments);
		return "list";
	}

	@RequestMapping(value = "{documentId}", method = RequestMethod.POST)
	public String create(@PathVariable Integer documentId, @Validated CommentForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// TODO:: 에러 처리 필요
			return list(model);
		}
		Document document = documentService.findOne(documentId);

		Comment comment = new Comment();
		BeanUtils.copyProperties(form, comment);
		comment.setDocument(document);
		comment.setRegDate(new Date());
		User writer = userService.findOne(form.getUserId());
		comment.setWriter(writer);
		commentService.create(comment);
		return "redirect:/";
	}

	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
	public String editForm(@RequestParam Integer id, CommentForm form) {
		Comment comment = commentService.findOne(id);
		BeanUtils.copyProperties(comment, form);
		return "edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam Integer id, @Validated CommentForm form,
		BindingResult result) {
		if (result.hasErrors()) {
			return editForm(id, form);
		}
		Comment comment = new Comment();
		BeanUtils.copyProperties(form, comment);
		comment.setId(id);
		commentService.update(comment);
		return "redirect:/";
	}

	@RequestMapping(value = "edit", params = "goToTop")
	public String goToTop() {
		return "redirect:/";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam Integer id) {
		commentService.delete(id);
		return "redirect:/";
	}
}
