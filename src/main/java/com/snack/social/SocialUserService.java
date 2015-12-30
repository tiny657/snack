package com.snack.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class SocialUserService {

	@Autowired
	private SocialUserRepository socialUserRepository;

	public SocialUser create(UserProfileDto userProfileDto) throws DuplicateEmailException {
		SocialUser socialUser = SocialUser.fromVO(userProfileDto);

		if(existUser(socialUser.getEmail())) {
			throw new DuplicateEmailException("already registered email address");
		}

		socialUserRepository.save(socialUser);

		return socialUser;
	}

	public boolean existUser(String email) {
		SocialUser socialUser = findByEmail(email);

		return !ObjectUtils.isEmpty(socialUser);
	}

	public SocialUser findByEmail(String email) {
		return socialUserRepository.findByEmail(email);
	}
}
