package com.snack.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class UserController {
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		return "profile";
	}
}
