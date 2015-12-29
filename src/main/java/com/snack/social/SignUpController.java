package com.snack.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignUpController {

	@Autowired
	private ProviderSignInUtils providerSignInUtils;

	@Autowired
	private SocialUserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String redirectRequestToRegistrationPage(WebRequest request, ModelMap modelMap) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		UserProfile userProfile = connection.fetchUserProfile();

		UserCreateRequestVO userCreateRequestVO = UserCreateRequestVO.fromSocialUserProfile(userProfile);

		try {
			SocialUser user = userService.create(userCreateRequestVO);
			providerSignInUtils.doPostSignUp(user.getEmail(), request);

			FrontUserDetail frontUserDetail = new FrontUserDetail(user);

			Authentication authentication = new UsernamePasswordAuthenticationToken(frontUserDetail, null, frontUserDetail.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			return String.format("redirect:/error?message=%s", e.getMessage());
		}

		return "redirect:/";
	}
//
//	@RequestMapping(value = "/signup", method = RequestMethod.POST)
//	public String registrationUser(@ModelAttribute UserCreateRequestVO userCreateRequestVO, WebRequest request) throws Exception {
//		try {
//			User user = userService.create(userCreateRequestVO);
//			providerSignInUtils.doPostSignUp(user.getEmail(), request);
//
//			FrontUserDetail frontUserDetail = new FrontUserDetail(user);
//
//			Authentication authentication = new UsernamePasswordAuthenticationToken(frontUserDetail, null, frontUserDetail.getAuthorities());
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//
//			return "redirect:/";
//		} catch (Exception e) {
//			return String.format("redirect:/error?message=%s", e.getMessage());
//		}
//	}
}
