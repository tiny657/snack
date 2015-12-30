package com.snack.social;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class SocialUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="first_name", length = 100)
	private String firstName;

	@Column(name = "last_name", length = 100)
	private String lastName;

	@Column(name = "email", length = 100)
	private String email;

	public static SocialUser fromVO(UserProfileDto userProfileDto) {
		SocialUser socialUser = new SocialUser();

		socialUser.setLastName(userProfileDto.getLastName());
		socialUser.setFirstName(userProfileDto.getFirstName());
		socialUser.setEmail(userProfileDto.getEmail());

		return socialUser;
	}
}
