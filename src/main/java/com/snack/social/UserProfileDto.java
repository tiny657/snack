package com.snack.social;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.social.connect.UserProfile;

@Getter
@Setter
public class UserProfileDto {

	private String email;

	private String password;

	private String firstName;

	private String lastName;

	public String getName() {
		return lastName + firstName;
	}

	public static UserProfileDto fromSocialUserProfile(UserProfile userProfile) {
		UserProfileDto userProfileDto = new UserProfileDto();
		BeanUtils.copyProperties(userProfile, userProfileDto, UserProfileDto.class);
		return userProfileDto;
	}
}
