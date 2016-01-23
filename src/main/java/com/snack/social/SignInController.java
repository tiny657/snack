package com.snack.social;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignInController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signup(WebRequest request, ModelMap modelMap) {
		return "redirect:" + request.getHeader("referer");
	}
}
