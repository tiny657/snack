package com.snack.error;

import com.snack.social.FrontUserDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping(value = "404", method = RequestMethod.GET)
	public String list(@AuthenticationPrincipal FrontUserDetail frontUserDetail, Model model) {
		// TODO:: always null
		if (!ObjectUtils.isEmpty(frontUserDetail)) {
			model.addAttribute("email", frontUserDetail.getUsername());
			model.addAttribute("name", frontUserDetail.getName());
			model.addAttribute("imageUrl", frontUserDetail.getSocialUser());
		}
		return "404";
	}
}
