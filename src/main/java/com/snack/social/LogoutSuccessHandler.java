package com.snack.social;

import com.snack.document.Utils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
		throws IOException, ServletException {

		setDefaultTargetUrl(getTargetUrlFromPath(request));
		setAlwaysUseDefaultTargetUrl(true);
		handle(request, response, authentication);
	}

	private String getTargetUrlFromPath(HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		return Utils.getPath(referer);
	}
}

