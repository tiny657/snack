package com.snack.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SnackUserDetailsService implements UserDetailsService {

	@Autowired
	private SocialUserService socialUserService;

	@Override
	public final FrontUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		SocialUser user = socialUserService.findByEmail(username);

		if(user == null) {
			throw new UsernameNotFoundException("Not Exist User");
		}

		return new FrontUserDetail(user);
	}
}
