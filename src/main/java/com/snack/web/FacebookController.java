//package com.snack.web;
//
//import org.springframework.social.facebook.api.Facebook;
//import org.springframework.social.facebook.api.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.inject.Inject;
//
//@Controller
//@RequestMapping("/")
//public class FacebookController {
//
//	private Facebook facebook;
//
//	@Inject
//	public FacebookController(Facebook facebook) {
//		this.facebook = facebook;
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String helloFacebook(Model model) {
//		if (!facebook.isAuthorized()) {
//			return "redirect:/connect/facebook";
//		}
//
//		model.addAttribute(facebook.userOperations().getUserProfile());
//		User userProfile = facebook.userOperations().getUserProfile();
//
//		return "list";
//	}
//}
